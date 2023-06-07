package com.orcas.model.request.token;

import com.alibaba.fastjson.annotation.JSONField;
import com.orcas.model.request.IValidate;
import com.orcas.util.Assert;
import com.orcas.util.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessTokenRequest implements Serializable, IValidate {
  public static final Long SERIAL_VERSION_UID = 1L;
  @Builder.Default
  @JSONField(name = "grant_type")
  private String grantType = "access_token";

  @JSONField(name = "client_id")
  private String clientId;
  /** 与京东服务器时差不能相差半小时以上，京东服务器时间为北京时间（年月日和时分秒中间有空格） */
  @Builder.Default
  private String timestamp =
      LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA));
  /** 京东用户名（需要保持与运营提供的采购账号一致，需要注意区分大小写） */
  private String username;
  /** 京东的密码，该字段需要把京东提供的密码进行32位md5加密，然后将结果转成小写进行传输 */
  private String password;

  /**
   * 签名,生成规则如下： 1. 按照以下顺序将字符串拼接起来 client_secret+timestamp+client_id+username+password
   * +grant_type+client_secret 其中 client_secret的值是京东分配的，以邮件形式发送给客户。 timestamp与同名入参传值一致。
   * client_id与同名入参传值一致。 username与同名入参传值一致。 password，32位小写MD5值，与同名入参传值一致。 grant_type，与同名入参传值一致。
   * 2、将上述拼接的字符串使用32位md5加密，然后将结果转成大写进行传输。
   */
  private String sign;

  @Override
  public void validate() {
    Assert.isNotBlank(clientId, "clientId");
    Assert.isNotBlank(username, "username");
    Assert.isNotBlank(password, "password");
  }

  public void buildSign(String clientSecret) {
    Assert.isNotBlank(clientSecret, "clientSecret");
    validate();
    // client_secret+timestamp+client_id+username+password
    // +grant_type+client_secret
    // password要32位小写MD5值，与同名入参传值一致
    String md5encrypt = CommonUtil.MD5encrypt(password);
    Assert.isTrue(StringUtils.isNotBlank(md5encrypt), "客户端密码MD5加密");
    this.password = md5encrypt;
    String signStr =
        clientSecret + timestamp + clientId + username + md5encrypt + grantType + clientSecret;
    String md5Sign = CommonUtil.MD5encrypt(signStr);
    Assert.isTrue(StringUtils.isNotBlank(md5Sign), "请求MD5签名");
    this.sign = md5Sign.toUpperCase(Locale.ROOT);
  }
}

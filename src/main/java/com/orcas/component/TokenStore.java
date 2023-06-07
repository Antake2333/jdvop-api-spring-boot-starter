package com.orcas.component;

import com.orcas.autoconfigure.JdVopProperties;
import com.orcas.client.TokenClient;
import com.orcas.constant.JdVopApiConstant;
import com.orcas.model.Token;
import com.orcas.model.request.token.AccessTokenRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Component
@ConditionalOnClass(TokenClient.class)
public class TokenStore {
  /** tokenMap获取token简单的封装 */
  private static final Map<String, Token> TOKEN_MAP =
      new ConcurrentHashMap<String, Token>() {
        {
          put(JdVopApiConstant.TOKEN, Token.builder().build());
        }
      };

  @Autowired private TokenClient tokenClient;

  /** 初始化token */
  private Token initToken() {
    JdVopProperties jdVopProperties = tokenClient.getJdVopProperties();
    Token token =
        tokenClient.getAccessToken(
            AccessTokenRequest.builder()
                .clientId(jdVopProperties.getClientId())
                .username(jdVopProperties.getUsername())
                .password(jdVopProperties.getPassword())
                .build(),
            jdVopProperties.getClientSecret());
    TOKEN_MAP.put(JdVopApiConstant.TOKEN, token);
    return token;
  }

  /**
   * 获取accessToken,暂时不做刷新
   *
   * @return
   */
  public String getAccessToken() {
    Token token = TOKEN_MAP.get(JdVopApiConstant.TOKEN);
    if (Objects.isNull(token) || StringUtils.isBlank(token.getAccessToken())) {
      token = initToken();
    } else {
      // 如果存在,判断token是否失效,失效也要重新获取
      // 这里要向前推进十分钟,避免刚好要失效的时候获取到
      if (Objects.isNull(token.getTime())
          || Objects.isNull(token.getExpiresIn())
          || LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli() - token.getTime()
              >= (token.getExpiresIn() * 1000 - 10 * 60 * 1000)) {
        token = initToken();
      }
    }
    return token.getAccessToken();
  }
}

package com.orcas.autoconfigure;

import com.dtflys.forest.utils.StringUtils;
import com.orcas.constant.JdVopApiConstant;
import com.orcas.util.Assert;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Orcas
 * @date 2022/10/22
 */
@ConfigurationProperties(prefix = JdVopApiConstant.JD_VOP)
public class JdVopProperties {
  private String url = JdVopApiConstant.MAIN_NET_URL;
  private String clientId;
  private String clientSecret;
  private String username;
  private String password;

  public String getUrl() {
    return url;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUrl(String url) {
    if (StringUtils.isBlank(url)) {
      this.url = JdVopApiConstant.MAIN_NET_URL;
    } else {
      this.url = url.lastIndexOf("/") == url.length() - 1 ? url : url + "/";
    }
  }

  public String getClientId() {
    Assert.isNotBlank(clientId, "clientId配置");
    return clientId;
  }

  public String getClientSecret() {
    Assert.isNotBlank(clientSecret, "clientSecret配置");
    return clientSecret;
  }

  public String getUsername() {
    Assert.isNotBlank(username, "username配置");
    return username;
  }

  public String getPassword() {
    Assert.isNotBlank(password, "password配置");
    return password;
  }
}

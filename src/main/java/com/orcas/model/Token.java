package com.orcas.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Token {
  private String uid;

  @JSONField(name = "access_token")
  private String accessToken;

  @JSONField(name = "refresh_token")
  private String refreshToken;

  /**
   * 毫秒
   */
  @JSONField(name = "refresh_token_expires")
  private Long refreshTokenExpires;

  private Long time;

  /**
   * 这里是秒
   */
  @JSONField(name = "expires_in")
  private Long expiresIn;
}

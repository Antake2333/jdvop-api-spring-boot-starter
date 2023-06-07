package com.orcas.client;

import com.dtflys.forest.Forest;
import com.dtflys.forest.utils.TypeReference;
import com.orcas.client.base.BaseClient;
import com.orcas.error.JdVopApiError;
import com.orcas.exception.JdVopApi4jException;
import com.orcas.model.Result;
import com.orcas.model.Token;
import com.orcas.model.request.token.AccessTokenRequest;
import com.orcas.util.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Component
@Slf4j
public class TokenClient extends BaseClient {

  private static final String CURRENT_URL = "oauth2/";

  @Override
  public String getCurrentUrl() {
    return CURRENT_URL;
  }

  public Token getAccessToken(AccessTokenRequest request, String clientSecret) {
    Assert.isNotNull(request, "AccessTokenRequest");
    Assert.isNotBlank(clientSecret, "clientSecret");
    request.validate();
    request.buildSign(clientSecret);
    try {
      Result<Token> execute =
          Forest.post(getUrl() + "accessToken")
              .contentFormUrlEncoded()
              .addBody(request)
              .execute(new TypeReference<Result<Token>>() {});
      return execute.getResult();
    } catch (Exception e) {
      log.error("获取token失败", e);
      throw new JdVopApi4jException(JdVopApiError.JD_VOP_ERROR.getCode(), "获取token失败");
    }
  }
}

package com.orcas.client.base;

import com.dtflys.forest.Forest;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.utils.TypeReference;
import com.orcas.component.TokenStore;
import com.orcas.constant.JdVopApiConstant;
import com.orcas.model.Result;
import com.orcas.util.Assert;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Component
@ConditionalOnClass(TokenStore.class)
public abstract class SignClient extends BaseClient {
  @Autowired private TokenStore tokenStore;

  /**
   * post请求
   *
   * @param url url
   * @param body 参数体
   * @return
   */
  public <T> T post(String url, Object body, TypeReference<Result<T>> typeReference) {
    Assert.isNotBlank(url, "url");
    Assert.isNotNull(typeReference, "typeReference");
    ForestRequest<?> forestRequest =
        Forest.post(url)
            .contentFormUrlEncoded()
            .addBody(JdVopApiConstant.TOKEN, tokenStore.getAccessToken());
    if (Objects.nonNull(body)) {
      forestRequest.addBody(body);
    }
    Result<T> execute = forestRequest.execute(typeReference);
    return execute.getResult();
  }
}

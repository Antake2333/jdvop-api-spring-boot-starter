package com.orcas.client.base;

import com.dtflys.forest.Forest;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.utils.TypeReference;
import com.orcas.component.TokenStore;
import com.orcas.constant.JdVopApiConstant;
import com.orcas.error.JdVopApiError;
import com.orcas.exception.JdVopApi4jException;
import com.orcas.model.Result;
import com.orcas.util.Assert;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
@Slf4j
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
    try {
      ForestRequest<?> forestRequest =
          Forest.post(url)
              .contentFormUrlEncoded()
              .addBody(JdVopApiConstant.TOKEN, tokenStore.getAccessToken());
      if (Objects.nonNull(body)) {
        forestRequest.addBody(body);
      }
      Result<T> execute = forestRequest.execute(typeReference);
      // 判断结果是否是成功
      if (Objects.isNull(execute) || !execute.getSuccess()) {
        log.error("POST请求正确,但是返回结果不正确,结果为:{}", execute);
        throw new JdVopApi4jException(
            JdVopApiError.JD_VOP_ERROR.getCode(),
            StringUtils.isNotBlank(execute.getResultMessage())
                ? execute.getResultMessage()
                : "POST请求正确,但是返回结果不正确," + "错误码:" + execute.getResultCode());
      }
      log.info("POST请求成功,结果为:{}", execute.getResult());
      return execute.getResult();
    } catch (Exception e) {
      log.error("POST请请求异常", e);
      throw new JdVopApi4jException(JdVopApiError.JD_VOP_ERROR.getCode(), "POST请求异常");
    }
  }
}

package com.orcas.client.base;

import com.alibaba.fastjson.JSON;
import com.dtflys.forest.Forest;
import com.dtflys.forest.exceptions.ForestConvertException;
import com.dtflys.forest.exceptions.ForestHandlerException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.utils.TypeReference;
import com.orcas.component.TokenStore;
import com.orcas.constant.JdVopApiConstant;
import com.orcas.error.JdVopApiError;
import com.orcas.exception.JdVopApi4jException;
import com.orcas.model.Result;
import com.orcas.model.request.BaseRequest;
import com.orcas.util.Assert;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
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
        if (Objects.nonNull(execute)
            && JdVopApiConstant.TOKEN_EXPIRE_CODE.equals(execute.getResultCode())) {
          // 如果是TOKEN过期,手动触发token刷新
          log.info("调用接口token过期,触发token自动刷新");
          tokenStore.initToken();
        }
        throw new JdVopApi4jException(
            JdVopApiError.JD_VOP_ERROR.getCode(),
            StringUtils.isNotBlank(execute.getResultMessage())
                ? execute.getResultMessage()
                : "POST请求正确,但是返回结果不正确," + "错误码:" + execute.getResultCode());
      }
      log.info("POST请求成功,结果为:{}", execute.getResult());
      return execute.getResult();
    } catch (Exception e) {
      if (e instanceof JdVopApi4jException) {
        throw e;
      }
      if (e instanceof ForestHandlerException) {
        if (Objects.nonNull(e.getCause()) && e.getCause() instanceof ForestConvertException) {
          log.error("响应结果转换错误", e);
          throw new JdVopApi4jException(JdVopApiError.JD_VOP_ERROR.getCode(), "响应结果转换错误");
        }
      }
      log.error("POST请求异常", e);
      throw new JdVopApi4jException(JdVopApiError.JD_VOP_ERROR.getCode(), "POST请求异常");
    }
  }

  /**
   * 再抽象的调用方法,将返回参数,包装在入参里面,这样可以不用再写返回类型了
   *
   * @param url
   * @param request
   * @param <T>
   * @param <R>
   * @return
   */
  public <T extends BaseRequest<R>, R> R doExecute(String url, T request) {
    // 判断请求参数不能为空
    Assert.isNotBlank(url, "请求地址");
    Assert.isNotNull(request, "请求参数");
    // 调用校验方法
    request.validate();
    // 调用post方法,获取结果后返回
    Object result = post(url, request.into(), new TypeReference<Result<Object>>() {});
    if (Objects.isNull(result)) {
      return null;
    }
    try {
      return JSON.parseObject(result.toString(), getResponseClass(request));
    } catch (Exception e) {
      log.error("转换结果异常,返回结果:{}", result, e);
      throw new JdVopApi4jException(JdVopApiError.JD_VOP_ERROR.getCode(), "转换结果异常");
    }
  }

  /**
   * 获取返回值类型
   *
   * @param request
   * @param <R>
   * @return
   */
  private <R> Class<R> getResponseClass(BaseRequest<R> request) {
    Assert.isNotNull(request, "请求参数");
    try {
      return (Class<R>)
          ((ParameterizedType) request.getClass().getGenericSuperclass())
              .getActualTypeArguments()[0];
    } catch (Exception e) {
      log.error("获取返回类型异常", e);
      throw new JdVopApi4jException(JdVopApiError.JD_VOP_ERROR.getCode(), "获取返回类型异常");
    }
  }
}

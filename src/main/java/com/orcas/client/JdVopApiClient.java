package com.orcas.client;

import com.orcas.client.base.SignClient;
import com.orcas.constant.JdVopApiConstant;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.request.api.ApiRequest;
import com.orcas.util.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Component
@Slf4j
public class JdVopApiClient extends SignClient {
  @Override
  public String getCurrentUrl() {
    return "";
  }

  /**
   * 请求门面
   *
   * @param request
   * @param <T>
   * @param <R>
   */
  public <T extends BaseRequest<R>, R> R execute(ApiRequest<T, R> request) {
    Assert.isNotNull(request, "请求参数");
    request.validate();
    Assert.isTrue(
        request.getRequest().getClass().equals(request.getApi().getRequestClass()), "请求参数类型错误");
    // 这下可以直接调用API了
    return doExecute(
        JdVopApiConstant.MAIN_NET_URL + request.getApi().getUrl(), request.getRequest());
  }
}

package com.orcas.client;

import com.dtflys.forest.utils.TypeReference;
import com.orcas.client.base.SignClient;
import com.orcas.model.Result;
import com.orcas.model.request.order.OrderSubmitRequest;
import com.orcas.model.request.order.QueryOrderFreightRequest;
import com.orcas.model.request.order.QueryOrderPromiseInfoRequest;
import com.orcas.model.response.order.OrderSubmitResponse;
import com.orcas.model.response.order.QueryOrderFreightResponse;
import com.orcas.model.response.order.QueryOrderPromiseInfoResponse;
import com.orcas.util.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Component
@Slf4j
public class OrderClient extends SignClient {
  private static final String CURRENT_URL = "api/order/";

  @Override
  public String getCurrentUrl() {
    return CURRENT_URL;
  }

  /**
   * 查询配送预计送达时间
   *
   * @param request
   * @return
   */
  public QueryOrderPromiseInfoResponse queryOrderPromiseInfo(QueryOrderPromiseInfoRequest request) {
    Assert.isNotNull(request, "查询配送预计送达时间参数");
    request.validate();
    return post(
        getUrl() + "getPromiseInfo",
        request,
        new TypeReference<Result<QueryOrderPromiseInfoResponse>>() {});
  }

  /**
   * 查询运费
   *
   * @param request
   * @return
   */
  public QueryOrderFreightResponse queryOrderFreight(QueryOrderFreightRequest request) {
    Assert.isNotNull(request, "查询运费参数");
    request.validate();
    return post(
        getUrl() + "getFreight",
        request.intoJd(),
        new TypeReference<Result<QueryOrderFreightResponse>>() {});
  }

  /**
   * 提交订单
   *
   * @param request
   * @return
   */
  public OrderSubmitResponse orderSubmit(OrderSubmitRequest request) {
    Assert.isNotNull(request, "提交订单参数");
    request.validate();
    return post(
        getUrl() + "submitOrder",
        request.intoJd(),
        new TypeReference<Result<OrderSubmitResponse>>() {});
  }
}

package com.orcas.client;

import com.dtflys.forest.utils.TypeReference;
import com.orcas.client.base.SignClient;
import com.orcas.model.Result;
import com.orcas.model.request.order.*;
import com.orcas.model.response.order.*;
import com.orcas.util.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

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

  /**
   * 查询订单
   *
   * @param thirdOrder
   * @return
   */
  public String queryOrderByThirdOrder(String thirdOrder) {
    Assert.isNotBlank(thirdOrder, "第三方订单号（非京东订单号）");
    return post(
        getUrl() + "selectJdOrderIdByThirdOrder",
        new HashMap<String, String>() {
          {
            put("thirdOrder", thirdOrder);
          }
        },
        new TypeReference<Result<String>>() {});
  }

  /**
   * 确认订单
   *
   * @param request
   * @return
   */
  public Boolean orderConfirm(OrderConfirmRequest request) {
    Assert.isNotNull(request, "确认订单参数");
    request.validate();
    return post(getUrl() + "confirmOrder", request, new TypeReference<Result<Boolean>>() {});
  }

  /**
   * 批量查询订单是否可取消
   *
   * @param jdOrderIds
   * @return
   */
  public List<OrderCheckCancelBatchResponse> orderCheckCancelBatch(List<Long> jdOrderIds) {
    Assert.isNotNull(jdOrderIds, "京东订单号");
    Assert.isTrue(jdOrderIds.size() <= 20, "京东订单号不能超过20个");
    return post(
        getUrl() + "batchCheckCancel",
        new HashMap<String, String>(1) {
          {
            put(
                "jdOrderIds",
                String.join(",", jdOrderIds.stream().map(String::valueOf).toArray(String[]::new)));
          }
        },
        new TypeReference<Result<List<OrderCheckCancelBatchResponse>>>() {});
  }

  /**
   * 取消订单 详细看文档
   *
   * @param request
   * @return
   */
  public Boolean orderCancel(OrderCancelRequest request) {
    Assert.isNotNull(request, "取消订单参数");
    request.validate();
    return post(getUrl() + "cancel", request, new TypeReference<Result<Boolean>>() {});
  }

  /**
   * 查询父订单详情
   *
   * @param request
   * @return
   */
  public QueryPOrderDetailResponse queryPOrderDetail(QueryOrderDetailRequest request) {
    Assert.isNotNull(request, "查询订单详情参数");
    request.validate();
    return post(
        getUrl() + "selectJdOrder",
        request,
        new TypeReference<Result<QueryPOrderDetailResponse>>() {});
  }

  /**
   * 查询子订单详情
   *
   * @param request
   * @return
   */
  public QueryCOrderDetailResponse queryCOrderDetail(QueryOrderDetailRequest request) {
    Assert.isNotNull(request, "查询订单详情参数");
    request.validate();
    return post(
        getUrl() + "selectJdOrder",
        request,
        new TypeReference<Result<QueryCOrderDetailResponse>>() {});
  }

  /**
   * 查询订单配送信息
   *
   * @param request
   * @return
   */
  public QueryOrderTrackResponse queryOrderTrack(QueryOrderTrackRequest request) {
    Assert.isNotNull(request, "查询订单配送信息参数");
    request.validate();
    return post(
        getUrl() + "orderTrack", request, new TypeReference<Result<QueryOrderTrackResponse>>() {});
  }

  public void orderConfirmReceived(Long jdOrderId) {
    Assert.isNotNull(jdOrderId, "京东订单号");
    /*return post(
            getUrl() + "orderTrack", request, new TypeReference<Result<QueryOrderTrackResponse>>() {});*/
  }
}

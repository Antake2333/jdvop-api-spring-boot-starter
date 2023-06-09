package com.orcas.enums;

import com.orcas.model.request.order.*;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
public enum ApiEnum {
  /** 订单确认收货 */
  ORDER_CONFIRM_RECEIVED("api/order/confirmReceived", OrderConfirmReceivedRequest.class, "订单确认收货"),
  ORDER_CONFIRM_RECEIVED_BATCH("api/order/batchConfirmReceived", OrderConfirmReceivedBatchRequest.class, "订单批量确认收货"),
  ORDER_SAVE_OR_UPDATE_PONO("api/order/saveOrUpdatePoNo", OrderSaveOrUpdatePoNoRequest.class, "更新采购单号"),
  ORDER_QUERY_NEW_LIST("api/checkOrder/checkNewOrder", OrderQueryNewListRequest.class, "查询新建订单列表"),
  ORDER_QUERY_DLOK_LIST("api/checkOrder/checkDlokOrder", OrderQueryDlokListRequest.class, "查询妥投订单列表"),
  ;
  private final String url;
  private final Class<?> requestClass;

  ApiEnum(String url, Class<?> requestClass, String desc) {
    this.url = url;
    this.requestClass = requestClass;
  }

  ApiEnum(String url, Class<?> requestClass) {
    this.url = url;
    this.requestClass = requestClass;
  }

  public String getUrl() {
    return url;
  }

  public Class<?> getRequestClass() {
    return requestClass;
  }
}

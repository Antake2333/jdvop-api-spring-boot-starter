package com.orcas.enums;

import com.orcas.model.request.order.OrderConfirmReceivedRequest;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
public enum ApiEnum {
  /** 订单确认收货 */
  ORDER_CONFIRM_RECEIVED("api/order/confirmReceived", OrderConfirmReceivedRequest.class, "订单确认收货"),
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

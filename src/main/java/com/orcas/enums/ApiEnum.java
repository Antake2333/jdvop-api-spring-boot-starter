package com.orcas.enums;

import com.orcas.model.request.address.*;
import com.orcas.model.request.order.*;
import com.orcas.model.request.pay.PayOrderDoPayRequest;
import com.orcas.model.request.pay.PayQueryBalanceChangeDetailRequest;
import com.orcas.model.request.pay.PayQueryBalanceRequest;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
public enum ApiEnum {
  // 地址相关
  ADDRESS_GET_FIRST_ADDRESS("api/area/getProvince", AddressGetFirstRequest.class, "获取一级地址"),
  ADDRESS_GET_SECOND_ADDRESS("api/area/getProvince", AddressGetSecondRequest.class, "获取二级地址"),
  ADDRESS_GET_THIRD_ADDRESS("api/area/getCounty", AddressGetThirdRequest.class, "获取三级地址"),
  ADDRESS_GET_FORTH_ADDRESS("api/area/getTown", AddressGetForthRequest.class, "获取四级地址"),
  ADDRESS_CHECK_AREA("api/area/checkArea", CheckAreaRequest.class, "检查地址"),
  ADDRESS_GET_ADDRESS("api/area/getJDAddressFromAddress", AddressGetRequest.class, "地址转换成京东地址"),
  // 订单相关
  ORDER_CONFIRM_RECEIVED("api/order/confirmReceived", OrderConfirmReceivedRequest.class, "订单确认收货"),
  ORDER_CONFIRM_RECEIVED_BATCH("api/order/batchConfirmReceived", OrderConfirmReceivedBatchRequest.class, "订单批量确认收货"),
  ORDER_SAVE_OR_UPDATE_PONO("api/order/saveOrUpdatePoNo", OrderSaveOrUpdatePoNoRequest.class, "更新采购单号"),
  ORDER_QUERY_NEW_LIST("api/checkOrder/checkNewOrder", OrderQueryNewListRequest.class, "查询新建订单列表"),
  ORDER_QUERY_DLOK_LIST("api/checkOrder/checkDlokOrder", OrderQueryDlokListRequest.class, "查询妥投订单列表"),
  ORDER_QUERY_REFUSE_LIST("api/checkOrder/checkRefuseOrder", OrderQueryRefuseListRequest.class, "查询拒收订单列表"),
  ORDER_QUERY_COMPLETE_LIST("api/checkOrder/checkCompleteOrder", OrderQueryCompleteListRequest.class, "查询完成订单列表"),
  // 支付相关
  PAY_QUERY_BALANCE("api/price/getUnionBalance", PayQueryBalanceRequest.class, "查询余额"),
  PAY_QUERY_BALANCE_CHANGE_DETAIL("api/price/getBalanceDetail", PayQueryBalanceChangeDetailRequest.class, "查询余额变动明细"),
  PAY_ORDER_DO_PAY("api/order/doPay", PayOrderDoPayRequest.class, "发起支付"),
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

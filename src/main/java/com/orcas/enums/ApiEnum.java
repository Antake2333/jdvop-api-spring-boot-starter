package com.orcas.enums;

import com.orcas.model.request.address.*;
import com.orcas.model.request.aftersales.CreateAfsApplyRequest;
import com.orcas.model.request.aftersales.SupportedInfoRequest;
import com.orcas.model.request.order.*;
import com.orcas.model.request.pay.PayOrderDoPayRequest;
import com.orcas.model.request.pay.PayQueryBalanceChangeDetailRequest;
import com.orcas.model.request.pay.PayQueryBalanceRequest;
import com.orcas.model.request.product.*;

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
  // 商品相关
  PRODUCT_GET_POOL_CODE("api/product/getPageNum", ProductGetPoolCodeRequest.class, "获取商品池信息"),
  PRODUCT_QUERY_PRODUCT_CODE_FROM_POOL("api/product/querySkuByPage", QueryProductCodeFromPoolRequest.class, "从商品池子内通过商品编号查询商品信息"),
  PRODUCT_QUERY_PRODUCT_DETAIL("api/product/getDetail", QueryProductDetailRequest.class, "通过Sku查询商品详情"),
  PRODUCT_QUERY_PRODUCT_DETAIL_STYLE("api/product/getDetailStyle", QueryProductDetailStyleRequest.class, "查询商品详情装吧样式"),
  PRODUCT_QUERY_PRODUCT_IMAGE("api/product/skuImage", ProductQueryProductImageRequest.class, "查询商品图片"),
  PRODUCT_QUERY_PRODUCT_STATE("api/product/skuState", ProductQueryProductStateRequest.class, "查询商品上下架状态"),
  PRODUCT_QUERY_PRODUCT_SALE_STATE("api/product/check", ProductSaleStateCheckRequest.class, "验证商品可售性"),
  PRODUCT_QUERY_AREA_LIMIT("api/product/checkAreaLimit", ProductAreaLimitCheckRequest.class, "查询商品区域购买限制"),
  PRODUCT_QUERY_GIFT("api/product/batchGetSkuGift", QueryProductGiftRequest.class, "批量查询商品赠品信息"),
  PRODUCT_QUERY_YAN_BAO("api/product/getYanbaoSku", QueryProductYanBaoRequest.class, "批量查询商品延保信息"),
  PRODUCT_QUERY_IS_COD("api/product/getIsCod", QueryProductHdfkRequest.class, "批量查询商品货到付款"),
  PRODUCT_QUERY_BATCH_IS_COD("api/product/getBatchIsCod", QueryProductHdfkBatchRequest.class, "批量查询商品货到付款"),
  PRODUCT_QUERY_BY_PAGE("api/search/search", ProductPageSearchRequest.class, "搜索商品"),
  PRODUCT_QUERY_SIMILAR("api/product/getSimilarSku", ProductQuerySimilarRequest.class, "查询同类商品"),
  PRODUCT_QUERY_CATEGORY("api/product/getCategory", ProductQueryCategoryRequest.class, "查询分类信息"),
  PRODUCT_QUERY_RECOMMEND("api/stock/stockOutRecommend", QueryProductRecommendRequest.class, "无货查询推荐商品"),
  PRODUCT_SALE_STATE_AND_STOCK_CHECK("api/stock/checkSkuSaleStateAndStock", ProductSaleStateAndStockCheckRequest.class, "商品上下架状态和库存检查"),
  PRODUCT_QUERY_SELL_PRICE("api/price/getSellPrice", QueryProductSellPriceRequest.class, "商品售价查询"),
  PRODUCT_QUERY_STOCK("api/stock/getNewStockById", QueryProductStockRequest.class, "查询商品库存"),
  // 订单相关
  ORDER_QUERY_PROMISE_INFO("api/order/getPromiseInfo", QueryOrderPromiseInfoRequest.class, "查询配送预计送达时间"),
  ORDER_QUERY_FREIGHT("api/order/getFreight", QueryOrderFreightRequest.class, "查询运费"),
  ORDER_SUBMIT("api/order/submitOrder", OrderSubmitRequest.class, "提交订单"),
  ORDER_QUERY_BY_THIRD_ORDER("api/order/selectJdOrderIdByThirdOrder", OrderQueryByThirdOrderRequest.class, "查询订单"),
  ORDER_CONFIRM("api/order/confirmOrder", OrderConfirmRequest.class, "确认订单"),
  ORDER_CHECK_CANCEL_BATCH("api/order/batchCheckCancel", OrderCheckCancelBatchRequest.class, "批量查询订单是否可取消"),
  ORDER_CANCEL("api/order/cancel", OrderCancelRequest.class, "取消订单"),
  ORDER_QUERY_PORDER_DETAIL("api/order/selectJdOrder", QueryPOrderDetailRequest.class, "查询父订单详情"),
  ORDER_QUERY_CORDER_DETAIL("api/order/selectJdOrder", QueryCOrderDetailRequest.class, "查询子订单详情"),
  ORDER_QUERY_TRACK("api/order/orderTrack", QueryOrderTrackRequest.class, "查询订单配送信息"),
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
  // 售后
  AFTER_SALES_GET_GOODS_ATTRIBUTES("api/afterSaleNew/getGoodsAttributes", SupportedInfoRequest.class, "查询商品售后属性"),
  AFTER_SALES_APPLY("api/afterSaleNew/createAfsApply", CreateAfsApplyRequest.class, "申请售后"),
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

package com.orcas.model.request.order;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import com.orcas.model.request.BaseRequest;
import com.orcas.util.Assert;
import lombok.*;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class QueryOrderDetailRequest extends BaseRequest<JSONObject> {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 京东的订单单号(父订单号/子订单号) */
  private Long jdOrderId;
  /**
   * 扩展参数。支持多个状态组合查询[英文逗号间隔] orderType 订单类型 jdOrderState 京东订单状态 poNo 采购单号 finishTime 订单完成时间
   * createOrderTime 订单创建时间 paymentType 订单支付类型 outTime 订单出库时间 invoiceType 订单发票类型 skuPayDetails
   * 混合支付商品维度支付明细
   */
  @JSONField(name = "queryExts")
  private String params;

  @Override
  public void validate() {
    Assert.isNotNull(jdOrderId, "京东的订单单号");
  }

  @Override
  public TypeReference<JSONObject> getRespTypeReference() {
    return new TypeReference<JSONObject>() {};
  }
}

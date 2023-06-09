package com.orcas.model.request.order;

import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.order.OrderSaveOrUpdatePoNoResponse;
import com.orcas.util.Assert;
import lombok.*;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderSaveOrUpdatePoNoRequest extends BaseRequest<OrderSaveOrUpdatePoNoResponse> {
  /** 京东的订单单号(下单返回的父订单号) */
  private Long jdOrderId;
  /** 采购单号，长度范围[1-26] */
  private String poNo;

  @Override
  public void validate() {
    Assert.isNotNull(jdOrderId, "京东的订单单号");
    Assert.hasTxt(poNo, "采购单号", 1, 26);
  }
}

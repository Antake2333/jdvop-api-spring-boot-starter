package com.orcas.model.request.order;

import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.order.OrderConfirmReceivedResponse;
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
public class OrderConfirmReceivedRequest extends BaseRequest<OrderConfirmReceivedResponse> {
  /** 京东的订单单号(下单返回的父订单号) */
  private Long jdOrderId;

  @Override
  public void validate() {
    Assert.isNotNull(jdOrderId, "京东的订单单号");
  }
}

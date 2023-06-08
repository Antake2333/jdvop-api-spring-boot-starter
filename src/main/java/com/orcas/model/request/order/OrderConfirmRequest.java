package com.orcas.model.request.order;

import com.orcas.model.request.IValidate;
import com.orcas.util.Assert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderConfirmRequest implements Serializable, IValidate {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 京东的订单单号(下单返回的父订单号) */
  private Long jdOrderId;
  /** 采购单号 */
  private String poNo;

  @Override
  public void validate() {
    Assert.isNotNull(jdOrderId, "京东的订单单号");
  }
}

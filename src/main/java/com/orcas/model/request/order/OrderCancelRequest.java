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
public class OrderCancelRequest implements Serializable, IValidate {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 京东的订单单号(父订单号/子订单号) */
  private String jdOrderId;
  /** 取消理由【必传】；单选；优先传001~006；为其他取消原因时，传详细原因描述（不超过200字） */
  private String cancelReason;

  @Override
  public void validate() {
    Assert.isNotBlank(jdOrderId, "京东的订单单号");
    Assert.isNotBlank(cancelReason, "取消理由");
  }
}

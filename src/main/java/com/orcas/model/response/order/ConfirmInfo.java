package com.orcas.model.response.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
public class ConfirmInfo implements Serializable {
  public static final long serialVersionUID = 1L;
  /** 京东订单号 */
  private Long jdOrderId;
  /** 确认状态 1：成功，2：失败 */
  private Integer confirmState;
  /** 失败描述，成功时为null */
  private String errorMsg;
}

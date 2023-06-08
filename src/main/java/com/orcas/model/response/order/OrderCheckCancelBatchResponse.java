package com.orcas.model.response.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Data
public class OrderCheckCancelBatchResponse implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 京东订单号 */
  private Long jdOrderId;
  /** 是否可取消标识 True：可取消 False：不可取消 */
  private Boolean cancelFlag;
  /** 不可取消原因code码 */
  private String reasonCode;
  /** 不可取消原因描述 */
  private String reasonMessage;
}

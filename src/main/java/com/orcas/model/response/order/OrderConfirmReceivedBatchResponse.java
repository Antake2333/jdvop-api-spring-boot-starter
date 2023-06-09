package com.orcas.model.response.order;

import com.orcas.model.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderConfirmReceivedBatchResponse extends BaseResponse {
  private List<ConfirmInfo> confirmInfos;

  @Data
  public static class ConfirmInfo implements Serializable {
    public static final long serialVersionUID = 1L;
    /** 京东订单号 */
    private Long jdOrderId;
    /** 确认状态 1：成功，2：失败 */
    private Integer confirmState;
    /** 失败描述，成功时为null */
    private String errorMsg;
  }
}

package com.orcas.model.response.order;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Data
public class QueryOrderTrackResponse implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  private List<OrderTrack> orderTrack;
  private List<WaybillCode> waybillCode;

  @Data
  public static class OrderTrack implements Serializable {
    public static final Long SERIAL_VERSION_UID = 1L;
    /** 操作内容明细 */
    private String content;
    /** 操作时间。日期格式为“yyyy-MM-dd hh:mm:ss” */
    private String msgTime;
    /** 操作员名称。 */
    private String operator;
  }

  @Data
  public static class WaybillCode implements Serializable {
    public static final Long SERIAL_VERSION_UID = 1L;
    /** 订单号。 */
    private Long orderId;
    /** 父订单号。 此字段为0 未拆单 */
    private Long parentId;
    /** 承运商。可以为“京东快递”或是京东配送站点名称或者商家自行录入的承运商名称。 */
    private String carrier;
    /** 运单号。（可能没有，可能是京东订单号本身） */
    private String deliveryOrderId;
  }
}

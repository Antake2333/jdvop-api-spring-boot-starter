package com.orcas.model.response.order;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
public class OrderQueryCompleteListResponse {
  /** 订单总数 */
  private Integer total;
  /** 总页码数 */
  private Integer totalPage;
  /** 当前页码 */
  private Integer curPage;
  /** 订单信息列表 */
  private List<Order> orders;

  @Data
  public static class Order implements Serializable {
    public static final long serialVersionUID = 1L;
    /** 京东订单编号 */
    private Long jdOrderId;
    /** 订单状态 0 是新建 1是妥投 2是拒收 */
    private Integer state;
    /** 是否挂起 0为为挂起 1为挂起 */
    private Integer hangUpState;
    /** 开票方式(1为随货开票，0为订单预借，2为集中开票 ) */
    private Integer invoiceState;
    /** 订单金额 */
    private BigDecimal orderPrice;
    /** 订单创建时间，格式： yyyy-MM-dd HH:mm:ss */
    private String time;
  }
}

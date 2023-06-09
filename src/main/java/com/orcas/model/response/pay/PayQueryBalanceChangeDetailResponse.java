package com.orcas.model.response.pay;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
public class PayQueryBalanceChangeDetailResponse {
  private Integer total;
  private Integer pageSize;
  private Integer pageNo;
  private List<BalanceChangeDetail> data;

  @Data
  public static class BalanceChangeDetail implements Serializable {
    public static final Long SERIAL_VERSION_UID = 1L;
    /** 余额明细ID */
    private Long id;
    /** 账户类型 1：可用余额 2：锁定余额 */
    private Integer accountType;
    /** 金额（元），有正负，可以是零，表示订单流程变化，如退款时会先有一条退款申请的记录，金额为0 */
    private BigDecimal amount;
    /** 京东Pin */
    private String pin;
    /** 订单号 */
    private String orderId;
    /** 业务类型 */
    private Integer tradeType;
    /** 业务类型名称 */
    private String tradeTypeName;
    /** 余额变动日期 */
    private String createdDate;
    /** 备注信息 */
    private String notePub;
    /** 业务号，一般由余额系统，在每一次操作成功后自动生成，也可以由前端业务系统传入 */
    private Long tradeNo;
  }
}

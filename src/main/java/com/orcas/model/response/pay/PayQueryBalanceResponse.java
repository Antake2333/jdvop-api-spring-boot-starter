package com.orcas.model.response.pay;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
public class PayQueryBalanceResponse {

  /** 当type入参中包含1时，此对象出现。 */
  private Balance balance;
  /** 当type入参中包含2时，此对象出现。 */
  private Geious geious;

  @Data
  public static class Balance implements Serializable {
    public static final Long SERIAL_VERSION_UID = 1L;
    /** 入参的pin值。 */
    private String pin;
    /** 账户余额。 */
    private BigDecimal remainLimit;
  }

  @Data
  public static class Geious implements Serializable {
    public static final Long SERIAL_VERSION_UID = 1L;
    /** 入参的pin值。 */
    private String pin;
    /** 金采的违约金金额。 */
    private BigDecimal penaltySumAmt;
    /** 金采的总授信额度。 */
    private BigDecimal creditLimit;
    /** 金采的待还款额度。 */
    private BigDecimal debtSumAmt;
    /** 金采账户余额。 */
    private BigDecimal remainLimit;
  }
}

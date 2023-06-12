package com.orcas.model.response.aftersales;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 售后概要，字段太多了，要什么自己去文档里面拿
 */
@Data
public class AfterSaleNewResponse implements Serializable {

    /**
     * 京东子单号
     */
    private Long orderId;
    /**
     * 原始单号。售后换新单对应的原始订单编号
     */
    private Long originalOrderId;
    /**
     * 退货数量
     */
    private Integer refundNum;
    /**
     * 退款金额
     */
    private BigDecimal realRefundAmount;
}

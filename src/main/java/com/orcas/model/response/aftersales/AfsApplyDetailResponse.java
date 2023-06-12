package com.orcas.model.response.aftersales;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class AfsApplyDetailResponse implements Serializable {


    /**
     * 申请单维度退款明细
     */
    @Data
    public static class AfsRefundInfoResultDto{
        String thirdApplyId	;//客售后申请单号
        String originalOrderId	;//	京东订单号
        BigDecimal refundAmount	;//		退款⾦额
        Date modifyDate	;//完成时间
    }
}

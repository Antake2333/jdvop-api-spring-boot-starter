package com.orcas.model.response.aftersales;

import lombok.Data;

import java.io.Serializable;
/**
 * 查询物流信息
 */
@Data
public class WayBillInfoResponse implements Serializable {
    /**
     * 返回配送的信息。
     */
    private OrderTrack orderTrack;

    /**
     * 返回订单的运单信息。
     */
    private WaybillCode waybillCode;


    @Data
    public static class OrderTrack{
        /**
         * 操作内容明细
         */
        private String content;
        /**
         * 操作时间。日期格式为“yyyy-MM-dd hh:mm:ss”
         */
        private String msgTime;
        /**
         * 操作员名称。
         */
        private String operator;

    }

    @Data
    public static class WaybillCode{
        /**
         * 承运商。可以为“京东快递”或者商家自行录入的承运商名称。
         */
        private String carrier;
        /**
         * 运单号。
         */
        private String deliveryOrderId;
    }


}

package com.orcas.model.response.aftersales;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
/**
 * 查询商品售后属性
 */
@Data
public class SupportedInfoResponse implements Serializable {
    /**
     * 商品编码
     */
    private Long wareId;
    /**
     * 商品可售后数量。
     * 订单中商品发生退货和换货后，订单的可售后数量会相应减少。
     * 如果商品换货后需要再次售后，需要通过“售后换新订单”发起售后。
     * 售后换新单的退款金额会记录在原单，退货数量不会记录在原单。
     * 建议记录清楚售后换新单与原始单的关系。
     */
    private Integer wareNum;

    /**
     * 支持的服务类型。10退货，20换货，30维修预期
     * 为空可能代表当前没有可以售后的商品
     */
    private List<Integer> customerExpect;
    /**
     * 支持的返回京东方式。
     * 4上门取件， 7客户送货， 40客户发货。
     * 为空可能代表当前没有可以售后的商品
     */
    private List<Integer> pickupWareType;
}

package com.orcas.model.request.aftersales;

import com.orcas.model.request.BaseRequest;
import com.orcas.model.request.IValidate;
import com.orcas.util.Assert;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * 填写运单信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SaleSendInfoRequest extends BaseRequest<Void> {

    /**
     * 订单号，即京东子订单号
     */
    private Long orderId;
    /**
     * 京东PIN。必须是相同合同下的pin。
     * 该字段用于验证操作人权限。
     * 如果传入账号，则账号必须为订单下单人；
     * 如果不传入，则默认可操作主数据合同下所有的订单
     */
    private String customerPin;
    /**
     * 申请批次号，同一子订单下不可重复（长度最大20）
     */
    private String thirdApplyId;
    /**
     * 运单信息集合
     */
    private List<WaybillInfo> waybillInfoList;

    @Override
    public void validate() {
        Assert.isNotNull(orderId, "订单号，即京东子订单号");
        Assert.isNotNull(thirdApplyId, "申请批次号，同一子订单下不可重复（长度最大20）");
        waybillInfoList.forEach(WaybillInfo::validate);
    }

    /**
     * 运单信息集合
     */
    @Data
    public static class WaybillInfo implements Serializable, IValidate {
        /**
         * 发货公司
         */
        private String expressCompany;
        /**
         * 货运单号，字段长度不超过50
         */
        private String expressCode;
        /**
         * 发货日期，格式为yyyy-MM-dd HH:mm:ss
         */
        private String deliverDate;
        /**
         * 运费
         */
        private BigDecimal freightMoney;
        /**
         * 商品编号
         */
        private Long wareId;
        /**
         * 商品类型。10主商品，20赠品。
         */
        private Integer wareType;
        /**
         * 商品数量
         */
        private Integer wareNum;

        @Override
        public void validate() {
            Assert.isNotNull(expressCompany, "发货公司");
            Assert.isNotNull(expressCode, "货运单号");
            Assert.isNotNull(deliverDate, "发货日期");
            Assert.isNotNull(freightMoney, "运费");
            Assert.isNotNull(wareId, "商品编号");
            Assert.isNotNull(wareType, "商品类型。10主商品，20赠品。");
            Assert.isNotNull(wareNum, "商品数量");
        }
    }

    @Override
    public Object into() {
        return new HashMap<String, SaleSendInfoRequest>(1) {
            {
                put("param", SaleSendInfoRequest.this);
            }
        };
    }
}

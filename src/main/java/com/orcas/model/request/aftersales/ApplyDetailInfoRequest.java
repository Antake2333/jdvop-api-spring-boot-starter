package com.orcas.model.request.aftersales;

import com.orcas.model.request.BaseRequest;
import com.orcas.util.Assert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

/**
 * 查询售后明细
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplyDetailInfoRequest extends BaseRequest {

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
     * 获取信息模块：
     * 1、代表增加获取退款明细；
     * 2、代表增加获取客户发货信息
     */
    private List<Integer> appendInfoSteps;

    @Override
    public void validate() {
        Assert.isNotNull(orderId, "订单号，即京东子订单号");
        Assert.isNotNull(thirdApplyId, "订单号，即京东子订单号");
        Assert.isNotNull(appendInfoSteps, "获取信息模块");

    }

    @Override
    public Object into() {
        return new HashMap<String, ApplyDetailInfoRequest>(1) {
            {
                put("param", ApplyDetailInfoRequest.this);
            }
        };
    }
}

package com.orcas.model.request.aftersales;

import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.aftersales.WayBillInfoResponse;
import com.orcas.util.Assert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

/**
 * 查询物流信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RenewOrderRelationshipInfosRequest extends BaseRequest<List<WayBillInfoResponse>> {
    /**
     * 当前页号，默认为1
     */
    private Integer pageNo;
    /**
     * 每页数据条数默认10，最大100
     */
    private Integer pageSize;
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
     * 原始订单号
     */
    private String originalOrderId;

    @Override
    public void validate() {
        Assert.isNotNull(pageSize, "每页数据条数默认10，最大100");
        Assert.isNotNull(customerPin, "京东PIN。必须是相同合同下的pin。");
        Assert.isNotNull(thirdApplyId, "申请批次号，同一子订单下不可重复（长度最大20）");
        Assert.isNotNull(originalOrderId, "原始订单号");
    }

    @Override
    public Object into() {
        return new HashMap<String, RenewOrderRelationshipInfosRequest>(1) {
            {
                put("param", RenewOrderRelationshipInfosRequest.this);
            }
        };
    }
}

package com.orcas.model.request.aftersales;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.request.IValidate;
import com.orcas.model.response.aftersales.SupportedInfoResponse;
import com.orcas.util.Assert;
import lombok.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * 查询商品售后属性
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SupportedInfoRequest extends BaseRequest<SupportedInfoResponse> {

    /**
     * 订单号，即京东子订单号
     */
    private Long orderId;
    /**
     *京东PIN。必须是相同合同下的pin。
     * 该字段用于验证操作人权限。
     * 如果传入账号，则账号必须为订单下单人；
     * 如果不传入，则默认可操作主数据合同下所有的订单
     */
    private String customerPin;

    /**
     * 商品编码集合
     */
    private List<Long> wareIds;


    @Override
    public void validate() {
        Assert.isNotNull(orderId, "订单号，即京东子订单号");
        Assert.isNotNull(wareIds, "商品编码集合");
    }

    @Override
    public Object into() {
        return new HashMap<String, SupportedInfoRequest>(1) {
            {
                put("param", SupportedInfoRequest.this);
            }
        };
    }
}

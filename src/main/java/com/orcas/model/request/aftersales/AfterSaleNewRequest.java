package com.orcas.model.request.aftersales;

import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.aftersales.AfterSaleNewResponse;
import com.orcas.util.Assert;
import lombok.*;

import java.util.HashMap;

/**
 * 查询售后概要
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AfterSaleNewRequest extends BaseRequest<AfterSaleNewResponse> {

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
     * 申请批次号，同一子订单下不可重复（长度最大20）
     */
    private String thirdApplyId;
    /**
     * 第三方申请单号当前页号，默认为 1
     */
    private Integer applyPageNo;
    /**
     * 第三方申请每页行数，默认为20 ，max: 100
     */
    private Integer applyPageSize;
    /**
     * 商品编号。wareId为SKU编号时，表示特定SKU；wareId=1时表示选中所有SKU
     */
    private Integer wareId;
    /**
     * 商品维度信息当前页号，默认为 1
     */
    private Integer warePageNo;
    /**
     * 商品维度信息每页行数。默认为20 ，最大100
     */
    private Integer warePageSize;
    /**
     * canCancel//申请单是否可取消售后
     * canConfirm //申请单是否可以确认
     * canSendSku//申请单是否可以填写发运信息
     */
    private String queryExts;

    @Override
    public void validate() {
        Assert.isNotNull(orderId, "订单号，即京东子订单号");
    }

    @Override
    public Object into() {
        return new HashMap<String, Object>(2) {
            {
                put("param", AfterSaleNewRequest.this);
                put("queryExts",AfterSaleNewRequest.this.queryExts);
            }
        };
    }
}

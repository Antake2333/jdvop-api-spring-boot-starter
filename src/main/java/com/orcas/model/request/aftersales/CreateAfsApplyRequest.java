package com.orcas.model.request.aftersales;

import com.orcas.model.request.BaseRequest;
import com.orcas.model.request.IValidate;
import com.orcas.util.Assert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * 申请售后
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAfsApplyRequest extends BaseRequest<Void>{

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
     * 是否有发票
     */
    private Boolean isHasInvoice;
    /**
     * 用户信息
     */
    private AfsCustomerInfo customerInfo;

    /**
     * 取件信息，即原商品如何返回京东或者卖家
     */
    private AfsPickupWareInfo pickwareInfo;

    /**
     * 返件信息，商品如何返回客户手中。
     * 当售后类型为换货、维修时，表示商品如何返回客户手中；
     * 当售后类型为退货时，表示退货失败商品返回客户手中的地址。
     */
    private AfsReturnWareInfo returnWareInfo;
    /**
     * 申请信息集合。一个SKU只能有一个条目，一个SKU不能有两个或两个以上条目
     */
    private List<AfsApplyInfoItem> afsApplyInfoItemList;

    /**
     * 用户信息
     */
    @Data
    public static class AfsCustomerInfo implements Serializable, IValidate{

        /**
         * 用户名
         */
        private String customerName;
        /**
         * 联系人
         */
        private String customerContactName;
        /**
         * 联系电话，联系电话与手机号不能同时为空
         */
        private String customerTel;
        /**
         * 手机号，联系电话与手机号不能同时为空
         */
        private String customerMobilePhone;
        /**
         * Email
         */
        private String customerEmail;
        /**
         * 邮编
         */
        private String customerPostcode;

        @Override
        public void validate() {
            Assert.isNotNull(customerName, "用户名");
            Assert.isNotNull(customerContactName, "联系人");
        }
    }

    /**
     * 申请时取件信息
     */
    @Data
    public static class AfsPickupWareInfo implements Serializable,IValidate{
        /**
         * 取件方式。4上门取件7客户送货， 40客户发货。
         */
        private Integer pickwareType;
        /**
         * 取件省
         */
        private Integer pickWareProvince;
        /**
         * 取件市
         */
        private Integer pickWareCity;
        /**
         * 取件县
         */
        private Integer pickWareCounty;
        /**
         * 取件乡镇
         */
        private Integer pickWareVillage;
        /**
         * 取件街道地址
         */
        private String pickWareAddress;
        /**
         * 预约取件开始时间。
         * 开始时间不可早于当前时间+2小时。
         * 格式：2014-09-23 09:00:00
         */
        private String reserveDateBegin;
        /**
         * 预约取件结束时间。格式：2014-09-23 19:00:00
         */
        private String reserveDateEnd;


        @Override
        public void validate() {
            Assert.isNotNull(pickwareType, "取件方式。");
            Assert.isNotNull(pickWareProvince, "取件省。");
            Assert.isNotNull(pickWareCity, "取件市。");
            Assert.isNotNull(pickWareCounty, "取件县。");
            Assert.isNotNull(pickWareAddress, "取件街道地址。");
        }
    }

    /**
     * 申请时返件信息
     */
    @Data
    public static class AfsReturnWareInfo implements Serializable,IValidate{
        /**
         * 返件方式。10自营配送，20第三方配送
         */
        private Integer returnWareType;
        /**
         * 返件省
         */
        private Integer returnWareProvince;
        /**
         * 返件市
         */
        private Integer returnWareCity;
        /**
         * 返件县
         */
        private Integer returnWareCountry;
        /**
         * 返件乡镇
         */
        private Integer returnWareVillage;
        /**
         * 返件街道地址
         */
        private String returnWareAddress;

        @Override
        public void validate() {
            Assert.isNotNull(returnWareType, " 返件方式。");
            Assert.isNotNull(returnWareProvince, " 返件省。");
            Assert.isNotNull(returnWareCity, " 返件市。");
            Assert.isNotNull(returnWareCity, " 返件县。");
            Assert.isNotNull(returnWareCity, " 返件街道地址。");
        }
    }

    /**
     * 申请时申请条目
     */
    @Data
    public static class AfsApplyInfoItem implements Serializable,IValidate{
        /**
         * 客户期望售后类型。10退货，20换货，30维修
         */
        private Integer customerExpect;
        /**
         * 商品描述信息
         */
        private WareDescInfo wareDescInfo;
        /**
         * 商品及其数量
         */
        private WareDetailInfo wareDetailInfo;

        @Override
        public void validate() {
            Assert.isNotNull(customerExpect, "客户期望售后类型");
            wareDetailInfo.validate();
        }
    }

    /**
     * 商品及其数量
     */
    @Data
    public static class WareDetailInfo implements Serializable,IValidate{
        /**
         * 商品编号
         */
        private Long wareId;
        /**
         * 主商品编号
         */
        private Long mainWareId;
        /**
         * 商品名称
         */
        private String wareName;
        /**
         * 商品申请数量
         */
        private Integer wareNum;
        /**
         * 附件描述
         */
        private String wareDescribe;
        /**
         * 支付金额，即“商品单价*数量”
         */
        private BigDecimal payPrice;
        /**
         * 商品类型。10主商品，20赠品。
         */
        private Integer wareType;


        @Override
        public void validate() {
            Assert.isNotNull(wareId, "商品编号");
            Assert.isNotNull(mainWareId, "主商品编号");
            Assert.isNotNull(wareName, "商品名称");
            Assert.isNotNull(wareNum, "商品申请数量");
            Assert.isNotNull(wareType, "商品类型。10主商品，20赠品。");
        }
    }

    /**
     * 商品状况描述
     */
    @Data
    public static class WareDescInfo implements Serializable{
        /**
         * 是否需要检测报告
         */
        private Boolean isNeedDetectionReport;
        /**
         * 是否有防损吊牌
         */
        private Boolean lossPreventionTagFlag;
        /**
         * 是否有包装
         */
        private Boolean isHasPackage;
        /**
         * 包装描述
         */
        private Integer packageDesc;
        /**
         * 问题描述文字
         */
        private String questionDesc;
        /**
         * 问题描述图片链接。多个图片以“；”分隔
         */
        private String questionPic;
    }


    @Override
    public void validate() {
        Assert.isNotNull(orderId, "订单号，即京东子订单号");
        Assert.isNotNull(thirdApplyId, "申请批次号");
        Assert.isNotNull(customerInfo, "用户信息");
        Assert.isNotNull(pickwareInfo, "取件信息，即原商品如何返回京东或者卖家");
        Assert.isNotNull(returnWareInfo, "返件信息，商品如何返回客户手中");
        Assert.isNotNull(afsApplyInfoItemList, "申请信息集合");
        customerInfo.validate();
        pickwareInfo.validate();
        returnWareInfo.validate();
        afsApplyInfoItemList.stream().forEach(afsApplyInfoItem -> afsApplyInfoItem.validate());
    }

    @Override
    public Object into() {
        return new HashMap<String, CreateAfsApplyRequest>(1) {
            {
                put("param", CreateAfsApplyRequest.this);
            }
        };
    }
}

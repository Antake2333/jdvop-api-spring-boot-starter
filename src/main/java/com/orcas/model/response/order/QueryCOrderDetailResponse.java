package com.orcas.model.response.order;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Data
public class QueryCOrderDetailResponse implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 父订单号。为0时，此订单为父单。 */
  private Integer pOrder;
  /** 订单状态。0为取消订单 1为有效。 */
  private Integer orderState;
  /** 京东订单编号。 */
  private Long jdOrderId;
  /** 物流状态。0 是新建 1是妥投 2是拒收 */
  private Integer state;
  /** 预占确认状态。0没确认预占。 1已确认预占 */
  private Integer submitState;
  /** 订单类型。1是父订单 2是子订单。 */
  private Integer type;
  /** 运费：收取运费时返回 */
  private BigDecimal freight;
  /** 商品列表 */
  private List<Sku> sku;
  /** 订单总金额（不含运费） */
  private BigDecimal orderPrice;
  /**
   * 订单未含税金额。 （备注：仅做页面展示，订单未税金额最终以发票票面为准。客户如需在下单后开票前，获取尽量精准的订单未税金额，如用作以未税金额扣减预算等场景，可以联系VOP侧产品配置白名单）
   */
  private BigDecimal orderNakedPrice;
  /** 订单税额。 */
  private BigDecimal orderTaxPrice;
  /**
   * 订单类别。 查询参数queryExts中包含orderType。参考枚举值如下： 1.普通商品 2.大家电 3.实物礼品卡 4.售后换新单 5.厂家直送订单 6.FBP订单 7.生鲜
   * 11.IBS订单 20.电子卡 21.机票 22.酒店 23.合约机号卡 24.火车票[@文祥：更新新订单类型；父单子单的订单类型形成规则。特殊说明虚拟订单，虚拟订单通常有专门的查询接口]
   */
  private Integer orderType;
  /** 订单创建时间。 查询参数queryExts中包含createOrderTime。 输出格式为“yyyy-MM-dd hh:mm:ss” */
  private String createOrderTime;
  /** 订单完成时间。 查询参数queryExts中包含finishTime。 输出格式为“yyyy-MM-dd hh:mm:ss” 未完成时，此参数返回null。 */
  private String finishTime;
  /**
   * 京东状态。查询参数中包含queryExts=jdOrderState。参考枚举值如下： 1.新单 2.等待支付 3.等待支付确认 4.延迟付款确认 5.订单暂停 6.店长最终审核
   * 7.等待打印 8.等待出库 9.等待打包 10.等待发货 11.自提途中 12.上门提货 13.自提退货 14.确认自提 16.等待确认收货 17.配送退货 18.货到付款确认 19.已完成
   * 21.收款确认 22.锁定 29.等待三方出库 30.等待三方发货 31.等待三方发货完成
   */
  private Integer jdOrderState;
  /** 支付方式枚举值 1：货到付款 4：预存款 5：公司转账 101：京东金采 102：商城金采(一般不适用，仅限确认开通商城账期的特殊情况使用，请与业务确认后使用) 20为混合支付 */
  private Integer paymentType;
  /**
   * 混合支付明细， 当paymentType为20混合支付，返回值 [ { "payMoney":20, "paymentType":"17", "flag":"1" }, {
   * "payMoney":80, "paymentType":"4", "flag":"2" } ]
   */
  private List<PayDetail> payDeatails;
  /** 京东配送订单的出库时间/厂家直送订单的确认发货时间"2019-10-12 10:21:44" */
  private String outTime;
  /** 下单时的开票类型 2增值税专用发票；3 电子票 */
  private Integer invoiceType;

  @Data
  public static class Sku implements Serializable {
    public static final Long SERIAL_VERSION_UID = 1L;
    /** 商品名称。 */
    private String name;
    /** 京东商品编号。 */
    private Long skuId;
    /** 商品数量 */
    private Integer num;
    /** 京东三级分类。 */
    private Integer category;
    /** 商品价格 */
    private BigDecimal price;
    /** 商品税率。例如：本参数值返回13，代表税率为“13%” */
    private BigDecimal tax;
    /** 主商品ID */
    private Long oid;
    /** 商品类型。 0 普通、1 附件、2 赠品、3延保 */
    private Integer type;
    /** 运费拆分价格 */
    private BigDecimal splitFreight;
    /** 商品税额 */
    private BigDecimal taxPrice;
    /** 商品未含税金额 */
    private BigDecimal nakedPrice;

    private List<PayDetail> skuPayDetails;
  }

  @Data
  public static class PayDetail implements Serializable {
    public static final Long SERIAL_VERSION_UID = 1L;
    /** 支付金额 */
    private BigDecimal payMoney;
    /** 支付方式 支付类型 枚举定义 17, "微信支付" 101, "金采支付" 4,“预存款” */
    private Integer paymentType;
    /** 支付标识 支付标记 枚举定义 1 个人 2 */
    private Integer flag;
  }
}

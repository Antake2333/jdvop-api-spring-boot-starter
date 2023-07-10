package com.orcas.model.request.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.common.SkuNum;
import com.orcas.model.response.order.OrderSubmitResponse;
import com.orcas.util.Assert;
import lombok.*;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OrderSubmitRequest extends BaseRequest<OrderSubmitResponse> {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 第三方的订单单号，必须在100字符以内 */
  private String thirdOrder;
  /**
   * 下单商品信息 Json数组类型的字符串，参数格式：[{"skuId":商品编号, "num":商品数量, "price":10,"bNeedGift":false,
   * "yanbao":[{"skuId":商品编号}]}] (最高支持100种商品)
   */
  private List<OrderSkuNum> skuNums;
  /** 收货人姓名，最多20个字符 */
  private String name;
  /** 一级地址 */
  private Integer province;
  /** 二级地址 */
  private Integer city;
  /** 三级地址 */
  private Integer county;
  /** 四级地址 (如果该地区有四级地址，则必须传递四级地址，没有四级地址则传0) */
  @Builder.Default private Integer town = 0;

  /** 收货人详细地址，最多100个字符 */
  private String address;
  /** 邮编，最多20个字符 */
  private String zip;
  /** 座机号，最多20个字符 */
  private String phone;
  /** 手机号，最多20个字符 */
  private String mobile;
  /** 邮箱（接口需要，无实际业务意义，可固值xx） */
  private String email;
  /** 备注（少于100字） */
  private String remark;
  /** 开票方式(2为集中开票，4 订单完成后开票) */
  private Integer invoiceState;

  /** 发票类型（2增值税专用发票；3 电子票） 当发票类型为2时，开票方式只支持2集中开票 */
  private Integer invoiceType;

  /** 发票类型：4：个人，5：单位 */
  private Integer selectedInvoiceTitle;

  /** 发票抬头 (如果selectedInvoiceTitle=5则此字段必须) 需regCompanyName跟此字段传递一致 */
  private String companyName;

  /** 1:明细，100：大类 备注:若增值税专用发票则只能选1 明细 */
  private Integer invoiceContent;

  /** 支付方式枚举值 1：货到付款 4：预存款 5：公司转账 101：京东金采 102：商城金采(一般不适用，仅限确认开通商城账期的特殊情况使用，请与业务确认后使用) 20为混合支付 */
  private Integer paymentType;

  /**
   * 注意 支付明细， 当paymentType为20时候必须递此字段 flag为区分字段 枚举：1 为个人，2为企业 paymentType为 支付类型 枚举定义： 17, "微信支付"
   * 101, "金采支付", 4,“预存款” payMoney为支付金额 details 单位：元 [ { "payMoney":20, "paymentType":"17",
   * "flag":"1" }, { "payMoney":80, "paymentType":"4", "flag":"2" } ]
   */
  private String payDetails;

  /** 使用余额paymentType=4时，此值固定是1 其他支付方式0 */
  private Integer isUseBalance;

  /** 是否预占库存，0是预占库存（需要调用确认订单接口），1是不预占库存，直接进入生产 */
  private Integer submitState;

  /** 增专票收票人姓名 */
  private String invoiceName;
  /** 收票人电话 */
  private String invoicePhone;

  /** 增专票收票人所在省(京东地址编码) 选填 */
  private Integer invoiceProvice;

  /** 增专票收票人所在市(京东地址编码) 选填。 */
  private Integer invoiceCity;
  /** 增专票收票人所在区/县(京东地址编码) 选填 */
  private Integer invoiceCounty;

  /** 增专票收票人所在地址当invoiceType =2时，选填。 */
  private String invoiceAddress;
  /** 专票资质公司名称 该字段必填。 */
  private String regCompanyName;
  /** 专票资质纳税人识别号 该字段必填。 */
  private String regCode;

  /** 专票资质注册地址 选填。 */
  private String regAddr;
  /** 专票资质注册电话 选填。 */
  private String regPhone;

  /** 专票资质注册银行 选填。 */
  private String regBank;
  /** 专票资质银行账号 选填 */
  private String regBankAccount;
  /** 大家电配送日期：默认值为-1，0表示当天，1表示明天，2：表示后天; 如果为-1表示不使用大家电预约日历 */
  private Integer reservingDate;
  /** 大家电安装日期：默认按-1处理，0表示当天，1表示明天，2：表示后天 */
  private Integer installDate;
  /** 是否选择了安装，默认为true，选择了“暂缓安装”，此为必填项，必填值为false。 */
  @Builder.Default private Boolean needInstall = true;
  /** 中小件配送预约日期，格式：yyyy-MM-dd */
  private LocalDate promiseDate;
  /** 中小件配送预约时间段，时间段如： 9:00-15:00 */
  private String promiseTimeRange;
  /** 中小件预约时间段的标记 */
  private Integer promiseTimeRangeCode;
  /** 家电配送预约日期，格式：yyyy-MM-dd */
  private LocalDate reservedDate;
  /** 大家电配送预约时间段，如果：9:00-15:00 */
  private String reservedTimeRange;
  /** 循环日历, 客户传入最近一周可配送的时间段,客户入参:{"3": "09:00-10:00,12:00-19:00","4": "09:00-15:00"} */
  private String cycleCalendar;
  /** 采购单号，长度范围[1-26] */
  private String poNo;

  /** 节假日不可配送，默认值为false，表示节假日可以配送，为true表示节假日不配送 */
  @Builder.Default private Boolean validHolidayVocation = false;
  /** 第三方平台采购人账号 */
  private String thrPurchaserAccount;
  /** 第三方平台采购人姓名 */
  private String thrPurchaserName;
  /** 第三方采购人电话（手机号，固定电话区号+号码） */
  private String thrPurchaserPhone;
  /** C用户标识（仅限对接售后组件的客户使用） */
  private String cPin;
  /**
   * 对于有订单维度扩展字段需求的用户，提交订单时可以定义扩展字段信息，key需要提前申请开通，例： { "poNum": "20210419001"， "materialCode":
   * "ABC-123" }
   */
  private Map<String, Object> customOrderExt;

  @Override
  public void validate() {
    Assert.hasTxt(thirdOrder, "第三方的订单单号", 1, 100);
    Assert.isNotNull(skuNums, "下单商品信息");
    Assert.isTrue(skuNums.size() <= 100, "下单商品信息,最高支持100种商品");
    Assert.hasTxt(name, "收货人姓名", 1, 20);
    Assert.isNotNull(province, "一级地址编码");
    Assert.isNotNull(city, "二级地址编码");
    Assert.isNotNull(county, "三级地址编码");
    Assert.isNotNull(town, "四级地址编码");
    Assert.hasTxt(address, "收货人详细地址", 1, 100);
    Assert.hasTxtMaxIfPresent(zip, "邮编", 20);
    Assert.hasTxtMaxIfPresent(phone, "座机号", 20);
    Assert.hasTxt(mobile, "手机号", 1, 20);
    Assert.hasTxtMaxIfPresent(email, "邮箱", 100);
    Assert.hasTxtMaxIfPresent(remark, "备注", 100);
    Assert.isNotNull(invoiceState, "开票方式");
    Assert.isNotNull(invoiceType, "发票类型");
    Assert.isNotNull(selectedInvoiceTitle, "发票类型");
    Assert.isNotNull(invoiceContent, "发票内容");
    Assert.isNotNull(paymentType, "支付方式");
    if (Objects.nonNull(paymentType) && paymentType == 20) {
      Assert.isNotBlank(payDetails, "支付明细");
    }
    Assert.isNotNull(isUseBalance, "使用余额");
    Assert.isNotNull(submitState, "是否预占库存");
    Assert.isNotBlank(invoicePhone, "收票人电话");
    if (Objects.nonNull(invoiceType) && invoiceType != 2) {
      Assert.isNotBlank(invoiceAddress, "增专票收票人所在地址");
    }
    Assert.hasTxtIfPresent(poNo, "采购单号", 1, 26);
    Assert.isNotBlank(regCompanyName, "专票资质公司名称");
    Assert.isNotBlank(regCode, "专票资质纳税人识别号");
    if (Objects.nonNull(selectedInvoiceTitle) && selectedInvoiceTitle == 5) {
      Assert.isNotBlank(companyName, "发票抬头");
      Assert.isTrue(companyName.equals(regCompanyName), "发票抬头必须和专票资质公司名称一致");
    }
  }

  @Data
  public static class JdOrderSubmitRequest implements Serializable {
    public static final Long SERIAL_VERSION_UID = 1L;
    /** 第三方的订单单号，必须在100字符以内 */
    private String thirdOrder;

    private String sku;
    private String name;
    private Integer province;
    /** 二级地址 */
    private Integer city;
    /** 三级地址 */
    private Integer county;
    /** 四级地址 (如果该地区有四级地址，则必须传递四级地址，没有四级地址则传0) */
    private Integer town = 0;
    /** 收货人详细地址，最多100个字符 */
    private String address;
    /** 邮编，最多20个字符 */
    private String zip;
    /** 座机号，最多20个字符 */
    private String phone;
    /** 手机号，最多20个字符 */
    private String mobile;
    /** 邮箱（接口需要，无实际业务意义，可固值xx） */
    private String email;
    /** 备注（少于100字） */
    private String remark;
    /** 开票方式(2为集中开票，4 订单完成后开票) */
    private Integer invoiceState;
    /** 发票类型（2增值税专用发票；3 电子票） 当发票类型为2时，开票方式只支持2集中开票 */
    private Integer invoiceType;
    /** 发票类型：4：个人，5：单位 */
    private Integer selectedInvoiceTitle;
    /** 发票抬头 (如果selectedInvoiceTitle=5则此字段必须) 需regCompanyName跟此字段传递一致 */
    private String companyName;
    /** 1:明细，100：大类 备注:若增值税专用发票则只能选1 明细 */
    private Integer invoiceContent;
    /** 支付方式枚举值 1：货到付款 4：预存款 5：公司转账 101：京东金采 102：商城金采(一般不适用，仅限确认开通商城账期的特殊情况使用，请与业务确认后使用) 20为混合支付 */
    private Integer paymentType;
    /**
     * 注意 支付明细， 当paymentType为20时候必须递此字段 flag为区分字段 枚举：1 为个人，2为企业 paymentType为 支付类型 枚举定义： 17, "微信支付"
     * 101, "金采支付", 4,“预存款” payMoney为支付金额 details 单位：元 [ { "payMoney":20, "paymentType":"17",
     * "flag":"1" }, { "payMoney":80, "paymentType":"4", "flag":"2" } ]
     */
    private String payDetails;
    /** 使用余额paymentType=4时，此值固定是1 其他支付方式0 */
    private Integer isUseBalance;
    /** 是否预占库存，0是预占库存（需要调用确认订单接口），1是不预占库存，直接进入生产 */
    private Integer submitState;
    /** 增专票收票人姓名 */
    private String invoiceName;
    /** 收票人电话 */
    private String invoicePhone;
    /** 增专票收票人所在省(京东地址编码) 选填 */
    private Integer invoiceProvice;
    /** 增专票收票人所在市(京东地址编码) 选填。 */
    private Integer invoiceCity;
    /** 增专票收票人所在区/县(京东地址编码) 选填 */
    private Integer invoiceCounty;
    /** 增专票收票人所在地址当invoiceType =2时，选填。 */
    private String invoiceAddress;
    /** 专票资质公司名称 该字段必填。 */
    private String regCompanyName;
    /** 专票资质纳税人识别号 该字段必填。 */
    private String regCode;
    /** 专票资质注册地址 选填。 */
    private String regAddr;
    /** 专票资质注册电话 选填。 */
    private String regPhone;
    /** 专票资质注册银行 选填。 */
    private String regBank;
    /** 专票资质银行账号 选填 */
    private String regBankAccount;
    /** 大家电配送日期：默认值为-1，0表示当天，1表示明天，2：表示后天; 如果为-1表示不使用大家电预约日历 */
    private Integer reservingDate;
    /** 大家电安装日期：默认按-1处理，0表示当天，1表示明天，2：表示后天 */
    private Integer installDate;
    /** 是否选择了安装，默认为true，选择了“暂缓安装”，此为必填项，必填值为false。 */
    private Boolean needInstall = true;
    /** 中小件配送预约日期，格式：yyyy-MM-dd */
    private String promiseDate;
    /** 中小件配送预约时间段，时间段如： 9:00-15:00 */
    private String promiseTimeRange;
    /** 中小件预约时间段的标记 */
    private Integer promiseTimeRangeCode;
    /** 家电配送预约日期，格式：yyyy-MM-dd */
    private String reservedDateStr;
    /** 大家电配送预约时间段，如果：9:00-15:00 */
    private String reservedTimeRange;
    /** 循环日历, 客户传入最近一周可配送的时间段,客户入参:{"3": "09:00-10:00,12:00-19:00","4": "09:00-15:00"} */
    private String cycleCalendar;
    /** 采购单号，长度范围[1-26] */
    private String poNo;
    /** 节假日不可配送，默认值为false，表示节假日可以配送，为true表示节假日不配送 */
    private Boolean validHolidayVocation = false;
    /** 第三方平台采购人账号 */
    private String thrPurchaserAccount;
    /** 第三方平台采购人姓名 */
    private String thrPurchaserName;
    /** 第三方采购人电话（手机号，固定电话区号+号码） */
    private String thrPurchaserPhone;
    /** C用户标识（仅限对接售后组件的客户使用） */
    private String cPin;
    /**
     * 对于有订单维度扩展字段需求的用户，提交订单时可以定义扩展字段信息，key需要提前申请开通，例： { "poNum": "20210419001"， "materialCode":
     * "ABC-123" }
     */
    private Map<String, Object> customOrderExt;
  }

  @EqualsAndHashCode(callSuper = true)
  @Data
  public static class OrderSkuNum extends SkuNum implements Serializable {
    public static final Long SERIAL_VERSION_UID = 1L;
    private String skuId;
    private Boolean bNeedGift;
    private BigDecimal price;
    private List<OrderYanBao> yanbao;
  }

  @Data
  public static class OrderYanBao implements Serializable {
    public static final Long SERIAL_VERSION_UID = 1L;
    private String skuId;
  }

  @Override
  public TypeReference<OrderSubmitResponse> getRespTypeReference() {
    return new TypeReference<OrderSubmitResponse>() {};
  }

  @Override
  public Object into() {
    JdOrderSubmitRequest request = new JdOrderSubmitRequest();
    request.setThirdOrder(thirdOrder);
    if (!CollectionUtils.isEmpty(skuNums)) {
      request.setSku(JSON.toJSONString(skuNums));
    }
    request.setName(name);
    request.setProvince(province);
    request.setCity(city);
    request.setCounty(county);
    request.setTown(town);
    request.setAddress(address);
    request.setZip(zip);
    request.setPhone(phone);
    request.setMobile(mobile);
    request.setEmail(email);
    request.setRemark(remark);
    request.setInvoiceState(invoiceState);
    request.setInvoiceType(invoiceType);
    request.setSelectedInvoiceTitle(selectedInvoiceTitle);
    request.setCompanyName(companyName);
    request.setInvoiceContent(invoiceContent);
    request.setPaymentType(paymentType);
    request.setPayDetails(payDetails);
    if (Objects.nonNull(paymentType) && paymentType == 4) {
      request.setIsUseBalance(1);
    } else {
      request.setIsUseBalance(0);
    }
    request.setSubmitState(submitState);
    request.setInvoiceName(invoiceName);
    request.setInvoicePhone(invoicePhone);
    request.setInvoiceProvice(invoiceProvice);
    request.setInvoiceCity(invoiceCity);
    request.setInvoiceCounty(invoiceCounty);
    request.setInvoiceAddress(invoiceAddress);
    request.setRegCompanyName(regCompanyName);
    request.setRegCode(regCode);
    request.setRegAddr(regAddr);
    request.setRegPhone(regPhone);
    request.setRegBank(regBank);
    request.setRegBankAccount(regBankAccount);
    request.setReservingDate(reservingDate);
    request.setInstallDate(installDate);
    request.setNeedInstall(needInstall);
    if (Objects.nonNull(promiseDate)) {
      request.setPromiseDate(promiseDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
    request.setPromiseTimeRange(promiseTimeRange);
    request.setPromiseTimeRangeCode(promiseTimeRangeCode);
    if (Objects.nonNull(reservedDate)) {
      request.setReservedDateStr(reservedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
    request.setReservedTimeRange(reservedTimeRange);
    request.setCycleCalendar(cycleCalendar);
    request.setPoNo(poNo);
    request.setValidHolidayVocation(validHolidayVocation);
    request.setThrPurchaserAccount(thrPurchaserAccount);
    request.setThrPurchaserName(thrPurchaserName);
    request.setThrPurchaserPhone(thrPurchaserPhone);
    request.setCPin(cPin);
    request.setCustomOrderExt(customOrderExt);
    return request;
  }
}

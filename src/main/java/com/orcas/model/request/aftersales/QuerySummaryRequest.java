package com.orcas.model.request.aftersales;

import com.alibaba.fastjson.JSONObject;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.request.IValidate;
import com.orcas.util.Assert;
import lombok.*;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * TODO 这里返回值有疑问,文档里面太乱了
 * @Description @Author LinLei @Date 2023/6/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QuerySummaryRequest extends BaseRequest<JSONObject> {
  private Param param;
  /** canCancel//申请单是否可取消售后 canConfirm //申请单是否可以确认 canSendSku//申请单是否可以填写发运信息 */
  private String queryExts;

  @Data
  public static class Param implements Serializable, IValidate {
    public static final Long SERIAL_VERSION_UID = 1L;
    /** 京东PIN必须是相同合同下的pin。该字段用于验证操作人权限。如果传入账号，则账号必须为订单下单人；如果不传入，则默认可操作主数据合同下所有的订单 */
    private String customerPin;
    /** 订单号，即京东子订单号 */
    private Long orderId;
    /** 第三方申请单号。thirdApplyId值为申请单编号时，表示特定申请单；thirdApplyId=1时表示选中所有申请单 */
    private String thirdApplyId;
    /** 第三方申请单号当前页号，默认为 1 */
    private Integer applyPageNo = 1;
    /** 第三方申请每页行数，默认为20 ，max: 100 */
    private Integer applyPageSize = 20;
    /** 商品编号。wareId为SKU编号时，表示特定SKU；wareId=1时表示选中所有SKU */
    private Long wareId;
    /** 商品维度信息当前页号，默认为 1 */
    private Integer warePageNo = 1;
    /** 商品维度信息每页行数。默认为20 ，最大100 */
    private Integer warePageSize = 20;

    @Override
    public void validate() {
      Assert.isNotNull(orderId, "param.orderId");
      Assert.validateIntegerMaxIfPresent(
          applyPageSize, "param.applyPageSize", BigInteger.valueOf(100));
      Assert.validateIntegerMaxIfPresent(
          warePageSize, "param.warePageSize", BigInteger.valueOf(100));
    }
  }

  @Override
  public void validate() {
    Assert.isNotNull(param, "param");
    param.validate();
  }
}

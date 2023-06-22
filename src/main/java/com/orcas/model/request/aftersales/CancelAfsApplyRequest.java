package com.orcas.model.request.aftersales;

import com.alibaba.fastjson.TypeReference;
import com.orcas.model.request.BaseRequest;
import com.orcas.util.Assert;
import lombok.*;

import java.util.HashMap;

/** 取消售后申请 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CancelAfsApplyRequest extends BaseRequest<Void> {

  /** 订单号，即京东子订单号 */
  private Long orderId;
  /** 京东PIN。必须是相同合同下的pin。 该字段用于验证操作人权限。 如果传入账号，则账号必须为订单下单人； 如果不传入，则默认可操作主数据合同下所有的订单 */
  private String customerPin;
  /** 申请批次号，同一子订单下不可重复（长度最大20） */
  private String thirdApplyId;
  /** 备注“”可以默认写取消“” */
  private String remark;

  @Override
  public void validate() {
    Assert.isNotNull(orderId, "订单号，即京东子订单号");
    Assert.isNotNull(thirdApplyId, "订单号，即京东子订单号");
    Assert.isNotNull(remark, "备注“”可以默认写取消“”");
  }

  @Override
  public TypeReference<Void> getRespTypeReference() {
    return new TypeReference<Void>() {};
  }

  @Override
  public Object into() {
    return new HashMap<String, CancelAfsApplyRequest>(1) {
      {
        put("param", CancelAfsApplyRequest.this);
      }
    };
  }
}

package com.orcas.model.request.pay;

import com.alibaba.fastjson.TypeReference;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.pay.PayQueryBalanceResponse;
import com.orcas.util.Assert;
import lombok.*;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PayQueryBalanceRequest extends BaseRequest<PayQueryBalanceResponse> {
  /** 京东PIN。必须是相同合同下的pin。 */
  private String pin;
  /** 账户余额类型。多选，可用英文逗号拼接。 参考枚举值如下： 1：账户余额。 2：金采余额。 */
  private String type;

  @Override
  public void validate() {
    Assert.isNotBlank(pin, "京东PIN不能为空");
    Assert.isNotBlank(type, "账户余额类型不能为空");
  }

  @Override
  public TypeReference<PayQueryBalanceResponse> getRespTypeReference() {
    return new TypeReference<PayQueryBalanceResponse>(){};
  }
}

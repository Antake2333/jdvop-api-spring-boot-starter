package com.orcas.model.request.pay;

import com.alibaba.fastjson.TypeReference;
import com.orcas.model.request.BaseRequest;
import lombok.*;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PayOrderDoPayRequest extends BaseRequest<Boolean> {
  /** 京东系统订单号 */
  private String jdOrderId;

  @Override
  public void validate() {}

  @Override
  public TypeReference<Boolean> getRespTypeReference() {
    return new TypeReference<Boolean>(){};
  }
}

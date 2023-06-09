package com.orcas.model.request.order;

import com.orcas.model.request.BaseRequest;
import com.orcas.util.Assert;
import lombok.*;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OrderQueryByThirdOrderRequest extends BaseRequest<String> {
  private String thirdOrder;

  @Override
  public void validate() {
    Assert.isNotBlank(thirdOrder, "第三方订单号（非京东订单号）");
  }
}

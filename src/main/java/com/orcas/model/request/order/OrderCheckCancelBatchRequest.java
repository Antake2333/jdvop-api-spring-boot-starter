package com.orcas.model.request.order;

import com.alibaba.fastjson.TypeReference;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.order.OrderCheckCancelBatchResponse;
import com.orcas.util.Assert;
import lombok.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OrderCheckCancelBatchRequest extends BaseRequest<List<OrderCheckCancelBatchResponse>> {
  public static final Long SERIAL_VERSION_UID = 1L;

  private List<Long> jdOrderIds;

  @Override
  public void validate() {
    Assert.isNotNull(jdOrderIds, "京东订单号");
    Assert.isTrue(jdOrderIds.size() <= 20, "京东订单号不能超过20个");
  }

  @Override
  public TypeReference<List<OrderCheckCancelBatchResponse>> getRespTypeReference() {
    return new TypeReference<List<OrderCheckCancelBatchResponse>>(){};
  }

  @Override
  public Object into() {
    return new HashMap<String, String>(1) {
      {
        put(
                "jdOrderIds",
                String.join(",", jdOrderIds.stream().map(String::valueOf).toArray(String[]::new)));
      }
    };
  }
}

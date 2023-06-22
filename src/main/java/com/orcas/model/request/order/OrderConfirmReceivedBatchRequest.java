package com.orcas.model.request.order;

import com.alibaba.fastjson.TypeReference;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.order.ConfirmInfo;
import com.orcas.util.Assert;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderConfirmReceivedBatchRequest extends BaseRequest<List<ConfirmInfo>> {
  /** 京东的订单单号(下单返回的父订单号) */
  private List<Long> jdOrderIds;

  @Override
  public void validate() {
    Assert.isNotNull(jdOrderIds, "京东的订单单号");
    Assert.isTrue(jdOrderIds.size() <= 50, "京东的订单单号不能超过50个");
  }

  @Override
  public TypeReference<List<ConfirmInfo>> getRespTypeReference() {
    return new TypeReference<List<ConfirmInfo>>(){};
  }

  @Override
  public Object into() {
    return new HashMap<String, String>(1) {
      {
        put(
            "jdOrderIds",
            jdOrderIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
      }
    };
  }
}

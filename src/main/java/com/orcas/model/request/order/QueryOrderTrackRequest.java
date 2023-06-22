package com.orcas.model.request.order;

import com.alibaba.fastjson.TypeReference;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.order.QueryOrderTrackResponse;
import com.orcas.util.Assert;
import lombok.*;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class QueryOrderTrackRequest extends BaseRequest<QueryOrderTrackResponse> {
  public static final Long SERIAL_VERSION_UID = 1L;

  /** 京东订单号 */
  private String jdOrderId;

  /** 是否返回订单的配送信息。0不返回配送信息。1，返回配送信息。 只支持最近2个月的配送信息查询。 */
  private Integer waybillCode;

  @Override
  public void validate() {
    Assert.isNotBlank(jdOrderId, "京东订单号");
  }

  @Override
  public TypeReference<QueryOrderTrackResponse> getRespTypeReference() {
    return new TypeReference<QueryOrderTrackResponse>() {};
  }
}

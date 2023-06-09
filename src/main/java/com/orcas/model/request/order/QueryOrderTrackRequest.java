package com.orcas.model.request.order;

import com.orcas.model.request.IValidate;
import com.orcas.util.Assert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryOrderTrackRequest implements Serializable, IValidate {
  public static final Long SERIAL_VERSION_UID = 1L;

  /** 京东订单号 */
  private String jdOrderId;

  /** 是否返回订单的配送信息。0不返回配送信息。1，返回配送信息。 只支持最近2个月的配送信息查询。 */
  private Integer waybillCode;

  @Override
  public void validate() {
    Assert.isNotBlank(jdOrderId, "京东订单号");
  }
}

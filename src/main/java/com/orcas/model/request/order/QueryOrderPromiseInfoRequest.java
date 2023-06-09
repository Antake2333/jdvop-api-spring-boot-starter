package com.orcas.model.request.order;

import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.order.QueryOrderPromiseInfoResponse;
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
public class QueryOrderPromiseInfoRequest extends BaseRequest<QueryOrderPromiseInfoResponse> {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 商品编号 */
  private String skuId;
  /** 数量 */
  private Long num;
  /** 一级地址 */
  private Integer province;
  /** 二级地址 */
  private Integer city;
  /** 三级地址 */
  private Integer county;
  /** 四级地址 (如果该地区有四级地址，则必须传递四级地址，没有四级地址则传0) */
  @Builder.Default private Integer town = 0;

  @Override
  public void validate() {
    Assert.isNotBlank(skuId, "商品编号");
    Assert.isNotNull(num, "数量");
    Assert.isNotNull(province, "一级地址");
    Assert.isNotNull(city, "二级地址");
    Assert.isNotNull(county, "三级地址");
    Assert.isNotNull(town, "四级地址");
  }
}

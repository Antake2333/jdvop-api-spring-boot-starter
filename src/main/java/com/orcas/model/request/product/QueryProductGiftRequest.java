package com.orcas.model.request.product;

import com.alibaba.fastjson.TypeReference;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.product.ProductPromotion;
import com.orcas.util.Assert;
import lombok.*;

import java.util.Map;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class QueryProductGiftRequest extends BaseRequest<Map<String, ProductPromotion>> {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 商品编号，支持批量，以，分隔 (最高支持100个商品) */
  private String skuIds;
  /** 京东一级地址编号 */
  private Integer province;
  /** 京东二级地址编号 */
  private Integer city;
  /** 京东三级地址编号 */
  private Integer county;
  /** 京东四级地址编号(如果该地区有四级地址，则必须传递四级地址，没有四级地址则传0) */
  @Builder.Default private Integer town = 0;

  @Override
  public void validate() {
    Assert.isNotBlank(skuIds, "商品编号");
    Assert.isNotNull(province, "一级地址编号");
    Assert.isNotNull(city, "二级地址编号");
    Assert.isNotNull(county, "三级地址编号");
    Assert.isNotNull(town, "四级地址编号");
  }

  @Override
  public TypeReference<Map<String, ProductPromotion>> getRespTypeReference() {
    return new TypeReference<Map<String, ProductPromotion>>() {};
  }
}

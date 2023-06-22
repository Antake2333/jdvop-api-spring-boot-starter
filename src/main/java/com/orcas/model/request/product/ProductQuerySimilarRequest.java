package com.orcas.model.request.product;

import com.alibaba.fastjson.TypeReference;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.product.ProductSimilar;
import com.orcas.util.Assert;
import lombok.*;

import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProductQuerySimilarRequest extends BaseRequest<List<ProductSimilar>> {
  private Long skuId;

  @Override
  public void validate() {
    Assert.isNotNull(skuId, "商品编码");
  }

  @Override
  public TypeReference<List<ProductSimilar>> getRespTypeReference() {
    return new TypeReference<List<ProductSimilar>>(){};
  }
}

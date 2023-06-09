package com.orcas.model.request.product;

import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.product.ProductDetailImage;
import com.orcas.util.Assert;
import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProductQueryProductImageRequest extends BaseRequest<Map<String, List<ProductDetailImage>>> {
  private String sku;

  @Override
  public void validate() {
    Assert.isNotBlank(sku, "sku");
  }
}

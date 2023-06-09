package com.orcas.model.request.product;

import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.product.ProductState;
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
public class ProductQueryProductStateRequest extends BaseRequest<List<ProductState>> {
  private String sku;

  @Override
  public void validate() {
    Assert.isNotBlank(sku, "sku");
  }
}

package com.orcas.model.request;

import com.orcas.util.Assert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkuRequest implements Serializable, IValidate {
  private String sku;

  @Override
  public void validate() {
    Assert.isNotBlank(sku, "sku");
  }
}

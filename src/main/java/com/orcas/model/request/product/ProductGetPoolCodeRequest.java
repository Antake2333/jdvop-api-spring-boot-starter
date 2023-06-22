package com.orcas.model.request.product;

import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.product.ProductPoolDetail;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductGetPoolCodeRequest extends BaseRequest<List<ProductPoolDetail>> {
  @JSONField(name = "queryExts")
  private String params;

  @Override
  public void validate() {}

  @Override
  public TypeReference<List<ProductPoolDetail>> getRespTypeReference() {
    return new TypeReference<List<ProductPoolDetail>>(){};
  }
}

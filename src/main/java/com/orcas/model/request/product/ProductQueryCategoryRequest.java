package com.orcas.model.request.product;

import com.alibaba.fastjson.TypeReference;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.common.Category;
import com.orcas.util.Assert;
import lombok.*;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProductQueryCategoryRequest extends BaseRequest<Category> {
  private Long cid;

  @Override
  public void validate() {
    Assert.isNotNull(cid, "分类id");
  }

  @Override
  public TypeReference<Category> getRespTypeReference() {
    return new TypeReference<Category>(){};
  }
}

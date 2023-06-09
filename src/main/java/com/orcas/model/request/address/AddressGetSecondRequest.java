package com.orcas.model.request.address;

import com.orcas.model.request.BaseRequest;
import com.orcas.util.Assert;
import lombok.*;

import java.util.HashMap;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AddressGetSecondRequest extends BaseRequest<HashMap<String, Integer>> {
  private Integer id;

  @Override
  public void validate() {
    Assert.isNotNull(id, "一级地址ID");
  }
}

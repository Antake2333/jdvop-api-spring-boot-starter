package com.orcas.model.request.address;

import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.address.AddressDetailResponse;
import com.orcas.util.Assert;
import lombok.*;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AddressGetRequest extends BaseRequest<AddressDetailResponse> {
  private String address;

  @Override
  public void validate() {
    Assert.isNotBlank(address, "地址");
  }
}

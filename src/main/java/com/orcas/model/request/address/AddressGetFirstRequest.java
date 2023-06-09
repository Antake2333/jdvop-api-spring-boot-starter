package com.orcas.model.request.address;

import com.orcas.model.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AddressGetFirstRequest extends BaseRequest<HashMap<String, Integer>> {
  @Override
  public void validate() {}
}

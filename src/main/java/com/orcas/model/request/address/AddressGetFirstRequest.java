package com.orcas.model.request.address;

import com.alibaba.fastjson.TypeReference;
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

  @Override
  public TypeReference<HashMap<String, Integer>> getRespTypeReference() {
    return new TypeReference<HashMap<String, Integer>>() {};
  }
}

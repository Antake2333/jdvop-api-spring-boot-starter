package com.orcas.model.response.order;

import com.orcas.model.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderSaveOrUpdatePoNoResponse extends BaseResponse {
  private Boolean result;
}

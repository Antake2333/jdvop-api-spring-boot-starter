package com.orcas.model.response.product;

import com.orcas.model.response.BaseResponse;
import lombok.Data;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
public class QueryProductRecommendResponse extends BaseResponse {
  private Long skuId;
}

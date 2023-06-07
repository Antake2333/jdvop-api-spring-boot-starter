package com.orcas.model.response.product;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Data
public class ProductSaleState implements Serializable {
  public static final long serialVersionUID = 1L;
  /** skuId */
  private Long sku;
  /** 1：上架，0：下架 */
  private Integer state;
}

package com.orcas.model.response.product;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Data
public class ProductAreaLimit implements Serializable {
  public static final long serialVersionUID = 1L;
  /** 商品编码 */
  private Long skuId;
  /** true 或空值代表区域受限 false 区域不受限 */
  private Boolean isAreaRestrict;
}

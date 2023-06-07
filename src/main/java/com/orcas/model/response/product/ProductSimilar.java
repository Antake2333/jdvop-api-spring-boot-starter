package com.orcas.model.response.product;

import com.orcas.model.response.common.SaleAttr;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
public class ProductSimilar implements Serializable {
  public static final long serialVersionUID = 1L;
  /** 维度 */
  private Integer dim;
  /** 销售名称 */
  private String saleName;
  /** 商品销售标签 销售属性下可能只有一个标签，此种场景可以选择显示销售名称和标签，也可以不显示 */
  private List<SaleAttr> saleAttrList;
}

package com.orcas.model.response.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
public class SaleAttr implements Serializable {
  public static final long serialVersionUID = 1L;
  /** 标签图片地址 */
  private String imagePath;
  /** 标签名称 */
  private String saleValue;
  /** 当前标签下的同类商品skuId */
  private Set<Long> skuIds;
}

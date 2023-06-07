package com.orcas.model.response.common;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
public class SkuNum implements Serializable {
  public static final long serialVersionUID = 1L;
  private Long skuId;
  private Long num;
  private BigDecimal price;
}

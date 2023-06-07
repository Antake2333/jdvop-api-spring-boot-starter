package com.orcas.model.response.product;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Data
public class ProductHdfk implements Serializable {
  public static final long serialVersionUID = 1L;
  /** 是否支持货到付款 */
  private Boolean payFirst;
  /** 错误原因 */
  private String nonCODmsg;
}

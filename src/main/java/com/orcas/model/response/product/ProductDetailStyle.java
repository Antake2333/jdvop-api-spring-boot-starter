package com.orcas.model.response.product;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
public class ProductDetailStyle implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  private String pcStyleUrl;
}

package com.orcas.model.response.address;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
public class CheckAreaResponse implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  private Boolean success;
  private Integer resultCode;
  private Integer addressId;
  private String message;
}

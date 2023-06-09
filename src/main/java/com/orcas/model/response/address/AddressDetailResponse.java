package com.orcas.model.response.address;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Data
public class AddressDetailResponse implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 国家ID */
  public String nationId;
  /** 国家名称 */
  public String nation;
  /** 一级地址ID */
  private Integer provinceId;
  /** 一级地址名称 */
  private String province;
  /** 二级地址ID */
  private Integer cityId;
  /** 二级地址名称 */
  private String city;
  /** 三级地址ID */
  private Integer countyId;
  /** 三级地址名称 */
  private String county;
  /** 四级地址ID */
  private Integer townId;
  /** 四级地址名称 */
  private String town;
}

package com.orcas.model.response.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
public class Category implements Serializable {
  public static final long serialVersionUID = 1L;
  /** 分类ID */
  private Integer catId;
  /** 父分类ID */
  private Integer parentId;
  /** 分类名称 */
  private String name;
  /** 0：一级分类；1：二级分类；2：三级分类； */
  private Integer catClass;
  /** 1：有效；0：无效； */
  private Integer state;
}

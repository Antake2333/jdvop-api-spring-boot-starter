package com.orcas.model.response.common;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
public class CategoryVO implements Serializable {
  public static final long serialVersionUID = 1L;
  /** 分类Id */
  private Integer catId;
  /** 分类下商品数量 */
  @JSONField(name = "Count")
  private Integer count;
  /** 分类名称 */
  @JSONField(name = "Name")
  private String name;
  /** 分类权重 */
  @JSONField(name = "Weight")
  private Integer weight;
}

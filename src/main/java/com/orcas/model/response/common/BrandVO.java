package com.orcas.model.response.common;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
public class BrandVO implements Serializable {
  public static final long serialVersionUID = 1L;
  /** 品牌id */
  @JSONField(name = "Id")
  private String id;
  /** 品牌名称 */
  @JSONField(name = "Name")
  private String name;
  /** 品牌首字母拼音 */
  @JSONField(name = "Pinyin")
  private String pinyin;
}

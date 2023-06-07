package com.orcas.model.response.common;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
public class HitResultVO implements Serializable {
  public static final long serialVersionUID = 1L;

  /** 品牌名称 */
  @JSONField(name = "Brand")
  private String brand;

  /** 商品图片url */
  private String imageUrl;
  /** 商品名称 */
  private String wareName;
  /** 商品id */
  private String wareId;

  /** 商品spuid */
  @JSONField(name = "warePId")
  private String warePid;

  /** 品牌id */
  private String brandId;
  /** 一级类目id */
  private String cid1;
  /** 二级类目id */
  private String cid2;
  /** 三级类目id */
  private String catId;

  /** 上柜状态，1.有效 */
  @JSONField(name = "Wstate")
  private String wstate;

  /** 商品状态，1.有效 */
  @JSONField(name = "Wyn")
  private String wyn;

  /** 一级分类名 */
  private String cid1Name;
  /** 二级分类名 */
  private String cid2Name;
  /** 三级分类名 */
  private String catName;

  /** 商品同义词 */
  @JSONField(name = "Synonyms")
  private String synonyms;
}

package com.orcas.model.response.product;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
public class ProductDetailImage implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  private Long id;
  /** sku编号 */
  private Long skuId;
  /** 图片路径 如3.3商品详情页面返回的图片地址一致。 */
  private String path;
  /** 创建日期 */
  private Date created;
  /** 更新时间 */
  private Date modified;
  /** 0:不可用;1:可用 */
  private Integer yn;
  /** 是否主图 1：是 0：否 */
  private Integer isPrimary;
  /** 排序 */
  private Integer orderSort;
  /** 位置 */
  private Integer position;
  /** 类型（0方图 1长图【服装】） */
  private Integer type;
  /** 特征 */
  private String features;
}

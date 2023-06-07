package com.orcas.model.response.product;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Data
public class ProductYanBao implements Serializable {
  public static final long serialVersionUID = 1L;
  /** 主商品的sku */
  private Long mainSkuId;
  /** 保障服务类别显示图标url */
  private String imgUrl;
  /** 保障服务类别静态页详情url */
  private String detailUrl;
  /** 保障服务类别显示排序 */
  private Integer displayNo;
  /** 保障服务分类编码 */
  private String categoryCode;
  /** 保障服务类别名称 */
  private String displayName;
  /** 保障服务商品详情列表 */
  private List<ProductYanBaoDetail> fuwuSkuDetailList;

  @Data
  static class ProductYanBaoDetail {
    /** 保障服务skuId */
    private Long bindSkuId;
    /** 保障服务sku名称（6字内） */
    private String bindSkuName;
    /** 显示排序 */
    private Integer sortIndex;
    /** 保障服务sku价格 */
    private BigDecimal price;
    /** 保障服务说明提示语（20字内） */
    private String tip;
    /** 是否是优惠保障服务（PC单品页、PC购物车会根据此标识是否展示优惠图标，优惠图标单品页提供） */
    private Boolean favor;
  }
}

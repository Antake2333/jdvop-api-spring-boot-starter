package com.orcas.model.request.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.orcas.model.request.IValidate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPageSearchRequest implements Serializable, IValidate {
  public static final Long SERIAL_VERSION_UID = 1L;

  /** 搜索关键字，需要编码 */
  @JSONField(name = "Keyword")
  private String keyword;

  /** 分类Id,只支持三级类目Id */
  private String catId;
  /** 当前第几页 */
  private Integer pageIndex;
  /** 当前页显示 */
  private Integer pageSize;

  /** 价格区间搜索，低价 */
  @JSONField(name = "Min")
  private String min;

  /** 价格区间搜索，高价 */
  @JSONField(name = "Max")
  private String max;

  /** 品牌搜索 多个品牌以逗号分隔，需要编码 */
  @JSONField(name = "Brands")
  private String brands;
  /** 一级分类 */
  private String cid1;
  /** 二级分类 */
  private String cid2;
  /** 一级地址,二级地址,三级地址英文逗号分隔 传入后且仅redisStore= true搜索地址有货的商品 示例：1,2810,51081 */
  private String areaIds;
  /** true仅搜索有货，false全部 */
  private Boolean redisStore;
  /**
   * 销量降序="sale_desc"; 价格升序="price_asc"; 价格降序="price_desc"; 上架时间降序="winsdate_desc";
   * 按销量排序_15天销售额="sort_totalsales15_desc"; 按15日销量排序="sort_days_15_qtty_desc";
   * 按30日销量排序="sort_days_30_qtty_desc"; 按15日销售额排序="sort_days_15_gmv_desc";
   * 按30日销售额排序="sort_days_30_gmv_desc";
   */
  private String sortType;
  /** 价格汇总 priceCol=”yes” */
  private String priceCol;
  /** 扩展属性汇总 extAttrCol=”yes” */
  private String extAttrCol;
  /** true:合并同一产品不同规格sku; false:不合并同一产品不同规格sku */
  private Boolean mergeSku;

  @Override
  public void validate() {}
}

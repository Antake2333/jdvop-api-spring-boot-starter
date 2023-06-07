package com.orcas.model.response.product;

import com.orcas.model.response.common.BrandVO;
import com.orcas.model.response.common.CategoryVO;
import com.orcas.model.response.common.HitResultVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
public class ProductPageSearchResponse implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 搜索结果总记录数量 */
  private Integer resultCount;
  /** 总页数 */
  private Integer pageCount;
  /** 每页大小 */
  private Integer pageSize;
  /** 当前页 */
  private Integer pageIndex;
  /** 品牌汇总信息 */
  private List<BrandVO> brandAggregate;
  /** 相关分类汇总信息 */
  private List<CategoryVO> categoryAggregate;
  /** 搜索命中数据json字符串，返回的图片地址拼接规则与查询商品详情规则一致 */
  private List<HitResultVO> hitResult;
}

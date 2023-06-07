package com.orcas.model.request.product;

import com.orcas.model.request.IValidate;
import com.orcas.util.Assert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryProductRecommendRequest implements Serializable, IValidate {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 主商品skuId */
  private Long skuId;
  /** 推荐商品的数量（种类）， 数值不能超过30 */
  private Integer limitNum;
  /** 格式：13_1000_4277_0 (分别代表1、2、3、4级地址) 如果获取不到地址，可以填0，则不进行库存过滤 */
  private String area;

  @Override
  public void validate() {
    Assert.isNotNull(skuId, "商品编号");
    Assert.isNotNull(limitNum, "一级地址编号");
    Assert.validateIntegerMaxIfPresent(limitNum, "limitNum", BigInteger.valueOf(30L));
    Assert.isNotBlank(area, "二级地址编号");
  }
}

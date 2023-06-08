package com.orcas.model.request.product;

import com.orcas.model.request.IValidate;
import com.orcas.model.response.common.SkuNum;
import com.orcas.util.Assert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryProductStockRequest implements Serializable, IValidate {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 格式：13_1000_4277_0 (分别代表1、2、3、4级地址) */
  private String area;
  /** 商品和数量 [{skuId: 569172,num:101}]。 “{skuId: 569172,num:10}”为1条记录，此参数最多传入100条记录。 */
  private List<SkuNum> skuNums;

  @Override
  public void validate() {
    Assert.isNotNull(skuNums, "商品和数量");
    Assert.isTrue(skuNums.size() <= 100, "商品和数量最多传入100条记录");
    Assert.isNotNull(area, "地址");
  }
}

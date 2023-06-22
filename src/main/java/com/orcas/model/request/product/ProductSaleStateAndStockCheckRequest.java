package com.orcas.model.request.product;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.common.SkuNum;
import com.orcas.model.response.product.ProductSaleStateAndStockCheckResponse;
import com.orcas.util.Assert;
import lombok.*;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProductSaleStateAndStockCheckRequest
    extends BaseRequest<List<ProductSaleStateAndStockCheckResponse>> {
  public static final Long SERIAL_VERSION_UID = 1L;

  /**
   * 商品、数量和价格 [{skuId: 569172,num:101,price:98.91},{skuId:
   * 321123,num:12,price:28.91}]。“{skuId:569172,num:101,price:98.91}”为1条记录，此参数最多传入100条记录。
   */
  private List<SkuNum> skuNums;
  /** 格式：13_1000_4277_0 (分别代表1、2、3、4级地址) */
  private String area;

  @Override
  public void validate() {
    Assert.isNotNull(skuNums, "商品、数量和价格");
    Assert.isTrue(skuNums.size() <= 100, "商品、数量和价格最多传入100条记录");
    Assert.isNotNull(area, "地址");
  }

  @Data
  public static class JdProductSaleStateAndStockCheckRequest implements Serializable {
    public static final Long SERIAL_VERSION_UID = 1L;
    /**
     * 商品、数量和价格 [{skuId: 569172,num:101,price:98.91},{skuId:
     * 321123,num:12,price:28.91}]。“{skuId:569172,num:101,price:98.91}”为1条记录，此参数最多传入100条记录。
     */
    private String skuNums;
    /** 格式：13_1000_4277_0 (分别代表1、2、3、4级地址) */
    private String area;
  }

  @Override
  public TypeReference<List<ProductSaleStateAndStockCheckResponse>> getRespTypeReference() {
    return  new TypeReference<List<ProductSaleStateAndStockCheckResponse>>(){};
  }

  @Override
  public Object into() {
    JdProductSaleStateAndStockCheckRequest request = new JdProductSaleStateAndStockCheckRequest();
    request.setArea(area);
    request.setSkuNums(CollectionUtils.isEmpty(skuNums) ? null : JSON.toJSONString(skuNums));
    return request;
  }
}

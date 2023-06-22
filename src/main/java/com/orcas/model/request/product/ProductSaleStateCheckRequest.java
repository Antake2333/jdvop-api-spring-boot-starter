package com.orcas.model.request.product;

import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.product.ProductSaleState;
import com.orcas.util.Assert;
import lombok.*;

import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProductSaleStateCheckRequest extends BaseRequest<List<ProductSaleState>> {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 商品编号，支持批量，以，分隔 (最高支持100个商品) */
  private String skuIds;
  /**
   * 扩展参数：英文逗号间隔输入 noReasonToReturn //无理由退货类型 thwa //无理由退货文案类型 isSelf // 是否自营 isJDLogistics //
   * 是否京东配送 taxInfo //商品税率 preDays//库存预占天数，超时未确认预占将取消订单
   */
  @JSONField(name = "queryExts")
  private String params;

  @Override
  public void validate() {
    Assert.isNotBlank(skuIds, "商品编号");
    Assert.isNotBlank(params, "扩展参数");
  }

  @Override
  public TypeReference<List<ProductSaleState>> getRespTypeReference() {
    return new TypeReference<List<ProductSaleState>>() {};
  }
}

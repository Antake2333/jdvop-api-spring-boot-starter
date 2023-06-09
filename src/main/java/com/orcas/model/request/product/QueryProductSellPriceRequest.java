package com.orcas.model.request.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.common.SkuNum;
import com.orcas.model.response.product.QueryProductSellPriceResponse;
import com.orcas.util.Assert;
import lombok.*;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class QueryProductSellPriceRequest extends BaseRequest<List<QueryProductSellPriceResponse>> {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 商品编号，请以，(英文逗号)分割。例如：129408,129409 (最高支持100个商品) */
  private String sku;
  /** [{"skuId":1234,"num":1},{"skuId":1234,"num":1}]，不传时取sku对应的商品编号，数量默认为1。此字段有值则不校验sku字段 */
  private List<SkuNum> skuInfos;
  /**
   * 为英文半角分隔的多个枚举值，枚举值不同，本接口的出参不同。枚举值如下： price //大客户默认价格(根据合同类型查询价格)。 marketPrice //市场价。 containsTax
   * //税率。出参增加tax,taxPrice,nakedPrice 3个字段。
   * nakedPrice//未税价。代表本客户为未税价下单模式（需要运营在主数据提前配置）；出参增加nakedPrice字段 (加此入参时，出参price也是未税价，此时price=
   * nakedPrice)
   */
  @JSONField(name = "queryExts")
  private String params;

  @Override
  public void validate() {
    if (CollectionUtils.isEmpty(skuInfos)) {
      Assert.isNotBlank(sku, "商品编号");
    }
  }
}

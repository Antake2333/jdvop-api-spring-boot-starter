package com.orcas.model.response.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryProductSellPriceResponse implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** skuId */
  private Long skuId;
  /** 京东价。仅供参考。 */
  private BigDecimal jdPrice;
  /** 京东销售价（含税价下单模式时返回含税单价；未税价下单模式时返回未税单价）。当此参数返回"null"或者返回值小于0时，表示暂无报价，建议客户前台不上架该SKU */
  private BigDecimal price;
  /** 价格描述 */
  private String priceDesc;
  /** 入参中的queryExts中包含marketPrice时，输出此字段。 京东的前台划线价。现在只有图书频道能露出，其他的因政策原因已不允许展示。 仅供参考 */
  private BigDecimal marketPrice;
  /** 税率。 当queryExts中包含containsTax时，出参中有此字段。 例如：此值为16时，代表税率为“16%”。 */
  private BigDecimal tax;
  /** 预估税额。 当queryExts中包含containsTax时，出参中有此字段。 */
  private BigDecimal taxPrice;
  /**
   * 未税价。 当queryExts中包含containsTax或nakedPrice时，出参中有此字段。 ①
   * 入参containsTax：此字段代表含税价订单体系下，单品的预估未税价，仅作页面展示，不作为订单、票面中最终的未税单价，因为下单后会有运费分摊、发票尾差校验等处理逻辑； ②
   * 入参nakedPrice：此字段代表未税价订单体系下，单品的未税单价，此时price= nakedPrice。
   */
  private BigDecimal nakedPrice;
}

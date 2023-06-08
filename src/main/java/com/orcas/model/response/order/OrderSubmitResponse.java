package com.orcas.model.response.order;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Data
public class OrderSubmitResponse implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 京东订单号 */
  private Long jdOrderId;
  /** 运费（订单运费，需要记录此金额，否则可能会导致订单金额不一致），收取运费时返回 */
  private BigDecimal freight;
  /** 订单总金额（不含运费） */
  private BigDecimal orderPrice;
  /** 订单未税金额（仅做页面展示，订单未税金额最终以发票票面为准。客户如需在下单后&开票前，获取尽量精准的订单未税金额，如用作以未税金额扣减预算等场景，可以联系VOP侧产品配置白名单） */
  private BigDecimal orderNakedPrice;
  /** 订单税额 */
  private BigDecimal orderTaxPrice;
  /** 订单包含的商品信息列表 */
  private List<BizSku> sku;

  @Data
  public static class BizSku implements Serializable {
    public static final Long SERIAL_VERSION_UID = 1L;
    /** 京东商品编号 */
    private Long skuId;
    /** 购买商品数量 */
    private Integer num;
    /** 商品分类编号 */
    private Integer category;
    /** 商品单价 */
    private BigDecimal price;
    /** 商品名称 */
    private String name;
    /** 商品税率 */
    private BigDecimal tax;
    /** 商品税额 */
    private BigDecimal taxPrice;
    /** 商品未税价 */
    private BigDecimal nakedPrice;
    /** 商品类型：0普通、1附件、2赠品、3延保 */
    private Integer type;
    /** 主商品skuid，如果本身是主商品，则oid为0 */
    private Long oid;
  }
}

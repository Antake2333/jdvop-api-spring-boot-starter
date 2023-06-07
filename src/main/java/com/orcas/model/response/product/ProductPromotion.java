package com.orcas.model.response.product;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Data
public class ProductPromotion implements Serializable {
  public static final long serialVersionUID = 1L;
  /** 赠品附件列表 */
  private List<Gift> gifts;
  /** 赠品要求最多购买数量（为0表示没配置） */
  private Integer maxNum;
  /** 赠品要求最少购买数量 （为0表示没配置） */
  private Integer minNum;
  /** 促销开始时间 */
  private Long promoStartTime;
  /** 促销结束时间 */
  private Long promoEndTime;

  @Data
  static class Gift {
    /** 赠品商品编码，主品是否有赠品以此为准，商品详情及商品主图赠品信息仅供参考 */
    private Long skuId;
    /** 数量 */
    private Integer num;
    /** 1：附件，2：赠品。 附件是指与主商品配套使用的部分，如空调的外机。赠品是不影响主商品使用的附赠商品。 下单时，可以选择是否要赠品，但附件默认都必须要。 */
    private Integer giftType;
  }
}

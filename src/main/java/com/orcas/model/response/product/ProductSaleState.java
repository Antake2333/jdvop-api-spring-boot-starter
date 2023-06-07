package com.orcas.model.response.product;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Data
public class ProductSaleState implements Serializable {
  public static final long serialVersionUID = 1L;
  /** 商品编号 */
  private Long skuId;
  /** 商品名称 */
  private String name;
  /** 是否可售，1：是，0：否 */
  private Integer saleState;
  /** 是否可开专票，1：支持，0：不支持 */
  private Integer isCanVAT;
  /**
   * 无理由退货类型：0,1,2,3,4,5,6,7,8. 0、3：不支持7天无理由退货； 1、5、8或null：支持7天无理由退货； 2：支持90天无理由退货； 4、7：支持15天无理由退货；
   * 6：支持30天无理由退货； （提示客户取到其他枚举值，无效）
   */
  private Integer noReasonToReturn;
  /**
   * 无理由退货文案类型： null：文案空； 0：文案空； 1：支持7天无理由退货； 2：支持7天无理由退货（拆封后不支持）； 3：支持7天无理由退货（激活后不支持）
   * 4：支持7天无理由退货（使用后不支持）； 5：支持7天无理由退货（安装后不支持）； 12：支持15天无理由退货； 13：支持15天无理由退货（拆封后不支持）；
   * 14：支持15天无理由退货（激活后不支持）； 15：支持15天无理由退货（使用后不支持）； 16：支持15天无理由退货（安装后不支持）； 22：支持30天无理由退货；
   * 23：支持30天无理由退货（安装后不支持）； 24：支持30天无理由退货（拆封后不支持）； 25：支持30天无理由退货（使用后不支持）； 26：支持30天无理由退货（激活后不支持）；
   * （提示客户取到其他枚举值，无效）
   */
  private Integer thwa;
}

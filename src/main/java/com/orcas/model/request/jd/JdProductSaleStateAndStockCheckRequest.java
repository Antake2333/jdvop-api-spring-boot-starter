package com.orcas.model.request.jd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JdProductSaleStateAndStockCheckRequest implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;

  /**
   * 商品、数量和价格 [{skuId: 569172,num:101,price:98.91},{skuId:
   * 321123,num:12,price:28.91}]。“{skuId:569172,num:101,price:98.91}”为1条记录，此参数最多传入100条记录。
   */
  private String skuNums;
  /** 格式：13_1000_4277_0 (分别代表1、2、3、4级地址) */
  private String area;
}

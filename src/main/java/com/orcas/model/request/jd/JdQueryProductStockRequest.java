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
public class JdQueryProductStockRequest implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 格式：13_1000_4277_0 (分别代表1、2、3、4级地址) */
  private String area;
  /** 商品和数量 [{skuId: 569172,num:101}]。 “{skuId: 569172,num:10}”为1条记录，此参数最多传入100条记录。 */
  private String skuNums;
}

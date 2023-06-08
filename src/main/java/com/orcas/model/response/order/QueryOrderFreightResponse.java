package com.orcas.model.response.order;

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
public class QueryOrderFreightResponse implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 总运费 */
  private BigDecimal freight;
  /** 基础运费 */
  private BigDecimal baseFreight;
  /** 偏远地区加收运费 */
  private BigDecimal remoteRegionFreight;
  /** 需收取偏远运费的sku */
  private String remoteSku;
  /** 续重运费 */
  private BigDecimal conFreight;
}

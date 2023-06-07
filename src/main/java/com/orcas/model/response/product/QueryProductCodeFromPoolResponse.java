package com.orcas.model.response.product;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Data
public class QueryProductCodeFromPoolResponse implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 剩余页数,如果=0，表示该池子已查完 */
  private Integer remainPage;
  /** skuId集合 */
  private List<Long> skus;
  /** 在下一次查询时使用（偏移量） */
  private Long offset;
}

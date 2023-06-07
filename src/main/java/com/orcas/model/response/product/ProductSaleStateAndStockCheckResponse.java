package com.orcas.model.response.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaleStateAndStockCheckResponse implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 商品编码 */
  private Long skuId;
  /** true 代表可采 false 代表不可采 */
  private Boolean canPurchase;
  /** 不可采的时候需要返回具体的不可采原因(导致sku不可采的所有原因) */
  private List<String> messageList;
}

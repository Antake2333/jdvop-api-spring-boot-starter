package com.orcas.model.request.product;

import com.orcas.model.request.IValidate;
import com.orcas.util.Assert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryProductCodeFromPoolRequest implements Serializable, IValidate {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 商品池编码 */
  private String pageNum;
  /** 每页大小，默认20，最大1000。建议 50 ~200 */
  @Builder.Default private Integer pageSize = 20;
  /** 偏移量，池id的首次查询传0，相同池id的后续请求赋值为上一次查询返回的偏移量 */
  @Builder.Default private Long offset = 0L;

  @Override
  public void validate() {
    Assert.isNotBlank(pageNum, "商品池编码");
    Assert.validateIntegerMaxIfPresent(pageSize, "每页大小", BigInteger.valueOf(1000L));
    Assert.isNotNull(offset, "偏移量");
  }
}

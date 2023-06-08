package com.orcas.model.response.product;

import com.alibaba.fastjson.annotation.JSONField;
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
public class QueryProductStockResponse implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** skuId */
  private Long skuId;
  /** 入参时传入的区域码area。 因京东目前是3、4级地址均支持，存在areaId在传入的3级地址后填充4级地址“_0“后返回的情况。 */
  private String areaId;
  /** 库存状态编号。 参考枚举值： 33,39,40,36,34,99 */
  private Integer stockStateId;
  /**
   * 库存状态描述。以下为stockStateId不同时，此字段不同的返回值： 33 有货 现货-下单立即发货 39 有货 在途-正在内部配货，预计2~6天到达本仓库 40 有货
   * 可配货-下单后从有货仓库配货 36 预订 34 无货 99 无货开预定，此时desc返回的数值代表预计到货天数，并且该功能需要依赖合同上有无货开预定权限的用户，到货周期略长，谨慎采用该功能。
   */
  @JSONField(name = "StockStateDesc")
  private String stockStateDesc;
  /**
   * 剩余数量。 当此值为-1时，为未查询到。 StockStateDesc为33： 入参的skuNums字段，skuId对应的num<50，此字段为实际库存。
   * 入参的skuNums字段，skuId对应的50<=num<100，此字段为-1。 入参的skuNums字段，skuId对应的num>100，此字段等于num。(此种情况并未返回真实京东库存)
   */
  private Integer remainNum;
}

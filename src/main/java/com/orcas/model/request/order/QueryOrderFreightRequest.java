package com.orcas.model.request.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.common.SkuNum;
import com.orcas.model.response.order.QueryOrderFreightResponse;
import com.orcas.util.Assert;
import lombok.*;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class QueryOrderFreightRequest extends BaseRequest<QueryOrderFreightResponse> {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 商品和数量 [{skuId: 569172,num:101}]。 “{skuId: 569172,num:10}”为1条记录，此参数最多传入100条记录。 */
  private List<SkuNum> skuNums;

  /** 一级地址 */
  private Integer province;
  /** 二级地址 */
  private Integer city;
  /** 三级地址 */
  private Integer county;
  /** 四级地址 (如果该地区有四级地址，则必须传递四级地址，没有四级地址则传0) */
  @Builder.Default private Integer town = 0;
  /** 京东支付方式 */
  private Integer paymentType;

  /** conFreight //续重运费 */
  @JSONField(name = "queryExts")
  private String params;

  @Override
  public void validate() {
    Assert.isNotNull(skuNums, "商品和数量");
    Assert.isTrue(skuNums.size() <= 50, "商品和数量最多传入100条记录");
    Assert.isNotNull(province, "一级地址");
    Assert.isNotNull(city, "二级地址");
    Assert.isNotNull(county, "三级地址");
    Assert.isNotNull(town, "四级地址");
    Assert.isNotNull(paymentType, "京东支付方式");
  }

  @Data
  public static class JdQueryOrderFreightRequest implements Serializable {
    public static final Long SERIAL_VERSION_UID = 1L;
    /** 商品和数量 [{skuId: 569172,num:101}]。 “{skuId: 569172,num:10}”为1条记录，此参数最多传入100条记录。 */
    private String sku;
    /** 一级地址 */
    private Integer province;
    /** 二级地址 */
    private Integer city;
    /** 三级地址 */
    private Integer county;
    /** 四级地址 (如果该地区有四级地址，则必须传递四级地址，没有四级地址则传0) */
    private Integer town = 0;
    /** 京东支付方式 */
    private Integer paymentType;
    /** conFreight //续重运费 */
    @JSONField(name = "queryExts")
    private String params;
  }

  @Override
  public TypeReference<QueryOrderFreightResponse> getRespTypeReference() {
    return new TypeReference<QueryOrderFreightResponse>() {};
  }

  @Override
  public Object into() {
    JdQueryOrderFreightRequest jdQueryOrderFreightRequest = new JdQueryOrderFreightRequest();
    if (!CollectionUtils.isEmpty(skuNums)) {
      jdQueryOrderFreightRequest.setSku(JSON.toJSONString(skuNums));
    }
    jdQueryOrderFreightRequest.setProvince(province);
    jdQueryOrderFreightRequest.setCity(city);
    jdQueryOrderFreightRequest.setCounty(county);
    jdQueryOrderFreightRequest.setTown(town);
    jdQueryOrderFreightRequest.setPaymentType(paymentType);
    return jdQueryOrderFreightRequest;
  }
}

package com.orcas.model.request.address;

import com.alibaba.fastjson.TypeReference;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.address.CheckAreaResponse;
import com.orcas.util.Assert;
import lombok.*;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CheckAreaRequest extends BaseRequest<CheckAreaResponse> {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 一级地址ID */
  private Integer provinceId;
  /** 二级地址ID */
  private Integer cityId;
  /** 是 三级地址ID */
  private Integer countyId;
  /** 四级地址ID（若三级地址下无四级地址传0） */
  @Builder.Default private Integer townId = 0;

  @Override
  public void validate() {
    Assert.isNotNull(provinceId, "一级地址ID");
    Assert.isNotNull(cityId, "二级地址ID");
    Assert.isNotNull(countyId, "三级地址ID");
    Assert.isNotNull(townId, "四级地址ID");
  }

  @Override
  public TypeReference<CheckAreaResponse> getRespTypeReference() {
    return new TypeReference<CheckAreaResponse>(){};
  }
}

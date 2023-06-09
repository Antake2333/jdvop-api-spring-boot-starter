package com.orcas.model.request.api;

import com.orcas.enums.ApiEnum;
import com.orcas.model.request.BaseRequest;
import com.orcas.model.request.IValidate;
import com.orcas.util.Assert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/9
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiRequest<T extends BaseRequest<R>, R> implements Serializable, IValidate {
  public static final Long SERIAL_VERSION_UID = 1L;
  private ApiEnum api;
  private T request;

  @Override
  public void validate() {
    Assert.isNotNull(api, "api");
    Assert.isNotNull(request, "request");
  }
}

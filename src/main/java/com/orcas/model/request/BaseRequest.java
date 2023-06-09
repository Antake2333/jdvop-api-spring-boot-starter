package com.orcas.model.request;

import com.orcas.enums.ApiEnum;
import com.orcas.model.request.api.ApiRequest;
import com.orcas.model.response.BaseResponse;
import com.orcas.util.Assert;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Data
public abstract class BaseRequest<R extends BaseResponse> implements Serializable, IValidate {
  public static final Long SERIAL_VERSION_UID = 1L;
  private Class<R> responseClass;

  /**
   * 转换成JD要的参数,可能向外提供的参数是自己的,传递给JD需要转换一下,需要重写一下该方法
   *
   * @return
   */
  public Object into() {
    return this;
  }

  /**
   * 转换成请求对象
   *
   * @param apiEnum
   * @return
   */
  public ApiRequest<? extends BaseRequest<R>, R> toApiRequest(ApiEnum apiEnum) {
    Assert.isNotNull(apiEnum, "apiEnum");
    return ApiRequest.<BaseRequest<R>, R>builder().request(this).api(apiEnum).build();
  }
}

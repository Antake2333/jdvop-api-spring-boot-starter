package com.orcas.client;

import com.dtflys.forest.utils.TypeReference;
import com.orcas.client.base.SignClient;
import com.orcas.constant.JdVopApiConstant;
import com.orcas.model.Result;
import com.orcas.model.request.address.CheckAreaRequest;
import com.orcas.model.response.AddressDetailResponse;
import com.orcas.util.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Slf4j
@Component
public class AddressClient extends SignClient {
  private static final String CURRENT_URL = "api/area/";

  @Override
  public String getCurrentUrl() {
    return CURRENT_URL;
  }

  /**
   * 获取一级地址
   *
   * @return
   */
  public HashMap<String, Integer> getFirstAddress() {
    return post(
        getUrl() + "getProvince", null, new TypeReference<Result<HashMap<String, Integer>>>() {});
  }

  /**
   * 获取二级地址
   *
   * @param id
   * @return
   */
  public HashMap<String, Integer> getSecondAddress(Integer id) {
    Assert.isNotNull(id, "一级地址ID");
    return post(
        getUrl() + "getCity",
        new HashMap<String, Object>(1) {
          {
            put("id", id);
          }
        },
        new TypeReference<Result<HashMap<String, Integer>>>() {});
  }

  /**
   * 获取三级地址
   *
   * @param id
   * @return
   */
  public HashMap<String, Integer> getThirdAddress(Integer id) {
    Assert.isNotNull(id, "二级地址ID");
    return post(
        getUrl() + "getCounty",
        new HashMap<String, Integer>(1) {
          {
            put("id", id);
          }
        },
        new TypeReference<Result<HashMap<String, Integer>>>() {});
  }

  /**
   * 获取四级地址
   *
   * @param id
   * @return
   */
  public HashMap<String, Integer> getForthAddress(Integer id) {
    Assert.isNotNull(id, "三级地址ID");
    return post(
        getUrl() + "getTown",
        new HashMap<String, Integer>(1) {
          {
            put("id", id);
          }
        },
        new TypeReference<Result<HashMap<String, Integer>>>() {});
  }

  /**
   * 检查地址
   *
   * @param request
   * @return
   */
  public Boolean checkArea(CheckAreaRequest request) {
    Assert.isNotNull(request, "检查地址请求参数");
    request.validate();
    HashMap<String, Object> execute =
        post(
            getUrl() + "checkArea",
            request,
            new TypeReference<Result<HashMap<String, Object>>>() {});
    Object result = execute.get(JdVopApiConstant.SUCCESS);
    if (Objects.isNull(result)) {
      return false;
    }
    try {
      return (boolean) result;
    } catch (Exception e) {
      log.error("检查地址异常", e);
      return false;
    }
  }

  /**
   * 地址转换成京东地址
   *
   * @param address
   * @return
   */
  public AddressDetailResponse getAddress(String address) {
    Assert.isNotBlank(address, "地址");
    return post(
        getUrl() + "getJDAddressFromAddress",
        new HashMap<String, String>(1) {
          {
            put("address", address);
          }
        },
        new TypeReference<Result<AddressDetailResponse>>() {});
  }
}

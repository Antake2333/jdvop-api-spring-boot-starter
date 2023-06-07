package com.orcas.client;

import com.dtflys.forest.utils.TypeReference;
import com.orcas.client.base.SignClient;
import com.orcas.model.Result;
import com.orcas.model.request.product.QueryProductCodeFromPoolRequest;
import com.orcas.model.response.product.ProductPoolDetail;
import com.orcas.util.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Slf4j
@Component
public class ProductClient extends SignClient {
  private static final String CURRENT_URL = "api/product/";

  @Override
  public String getCurrentUrl() {
    return CURRENT_URL;
  }

  /**
   * 获取商品池信息
   *
   * @param params
   * @return
   */
  public List<ProductPoolDetail> queryProductPoolCode(String params) {
    return post(
        getUrl() + "getPageNum",
        new HashMap<String, String>(1) {
          {
            put("queryExts", params);
          }
        },
        new TypeReference<Result<List<ProductPoolDetail>>>() {});
  }

  /**
   * 从商品池子内通过商品编号查询商品信息
   *
   * @param request
   * @return
   */
  public List<ProductPoolDetail> queryProductCodeFromPool(QueryProductCodeFromPoolRequest request) {
    Assert.isNotNull(request, "查询池内商品编号参数");
    request.validate();
    return post(
        getUrl() + "querySkuByPage",
        request,
        new TypeReference<Result<List<ProductPoolDetail>>>() {});
  }
}

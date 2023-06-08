package com.orcas.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.utils.TypeReference;
import com.orcas.client.base.SignClient;
import com.orcas.constant.JdVopApiConstant;
import com.orcas.model.Result;
import com.orcas.model.request.SkuRequest;
import com.orcas.model.request.jd.JdProductSaleStateAndStockCheckRequest;
import com.orcas.model.request.jd.JdQueryProductStockRequest;
import com.orcas.model.request.product.*;
import com.orcas.model.response.common.Category;
import com.orcas.model.response.product.*;
import com.orcas.util.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
  public QueryProductCodeFromPoolResponse queryProductCodeFromPool(
      QueryProductCodeFromPoolRequest request) {
    Assert.isNotNull(request, "查询池内商品编号参数");
    request.validate();
    return post(
        getUrl() + "querySkuByPage",
        request,
        new TypeReference<Result<QueryProductCodeFromPoolResponse>>() {});
  }

  /**
   * 通过Sku查询商品详情
   *
   * @param request
   * @return
   */
  public ProductDetail queryProductDetail(QueryProductDetailRequest request) {
    Assert.isNotNull(request, "查询商品详情参数");
    request.validate();
    return post(getUrl() + "getDetail", request, new TypeReference<Result<ProductDetail>>() {});
  }

  /**
   * 通过SKU查询商品详情装吧样式
   *
   * @param request
   * @return
   */
  public ProductDetailStyle queryProductDetailStyle(QueryProductDetailRequest request) {
    Assert.isNotNull(request, "查询商品详情装吧样式参数");
    request.validate();
    return post(
        getUrl() + "getDetailStyle", request, new TypeReference<Result<ProductDetailStyle>>() {});
  }

  /**
   * 查询商品图片
   *
   * @param request
   * @return
   */
  public Map<String, List<ProductDetailImage>> queryProductImage(SkuRequest request) {
    Assert.isNotNull(request, "查询商品详情图片参数");
    request.validate();
    return post(
        getUrl() + "skuImage",
        request,
        new TypeReference<Result<Map<String, List<ProductDetailImage>>>>() {});
  }

  /**
   * 查询商品上下架状态
   *
   * @param request
   * @return
   */
  public List<ProductState> queryProductState(SkuRequest request) {
    Assert.isNotNull(request, "查询商品上下架状态参数");
    request.validate();
    return post(getUrl() + "skuState", request, new TypeReference<Result<List<ProductState>>>() {});
  }

  /**
   * 商品可售性检查
   *
   * @param request
   * @return
   */
  public List<ProductSaleState> queryProductSaleState(ProductSaleStateCheckRequest request) {
    Assert.isNotNull(request, "验证商品可售性参数");
    request.validate();
    return post(
        getUrl() + "check", request, new TypeReference<Result<List<ProductSaleState>>>() {});
  }

  /**
   * 查询商品区域购买限制
   *
   * @param request
   * @return
   */
  public List<ProductAreaLimit> queryProductAreaLimit(ProductAreaLimitCheckRequest request) {
    Assert.isNotNull(request, "查询商品区域购买限制参数");
    request.validate();
    return post(
        getUrl() + "checkAreaLimit",
        request,
        new TypeReference<Result<List<ProductAreaLimit>>>() {});
  }

  /**
   * 批量查询商品赠品信息
   *
   * @param request
   * @return
   */
  public Map<String, ProductPromotion> queryProductGift(QueryProductGiftRequest request) {
    Assert.isNotNull(request, "批量查询商品赠品信息参数");
    request.validate();
    return post(
        getUrl() + "batchGetSkuGift",
        request,
        new TypeReference<Result<Map<String, ProductPromotion>>>() {});
  }

  /**
   * 批量查询商品延保信息
   *
   * @param request
   * @return
   */
  public Map<String, ProductYanBao> queryProductYanBao(QueryProductYanBaoRequest request) {
    Assert.isNotNull(request, "批量查询商品延保信息参数");
    request.validate();
    return post(
        getUrl() + "getYanbaoSku",
        request,
        new TypeReference<Result<Map<String, ProductYanBao>>>() {});
  }

  /**
   * @param request
   * @return
   */
  public Boolean queryProductHdfk(QueryProductHdfkRequest request) {
    Assert.isNotNull(request, "批量查询商品货到付款参数");
    request.validate();
    return post(getUrl() + "getIsCod", request, new TypeReference<Result<Boolean>>() {});
  }

  /**
   * 批量查询商品货到付款
   *
   * @param request
   * @return
   */
  public Map<String, ProductHdfk> queryProductHdfkBatch(QueryProductHdfkBatchRequest request) {
    Assert.isNotNull(request, "批量查询商品货到付款参数");
    request.validate();
    return post(
        getUrl() + "getBatchIsCod",
        request,
        new TypeReference<Result<Map<String, ProductHdfk>>>() {});
  }

  /**
   * 搜索商品
   *
   * @param request
   * @return
   */
  public ProductPageSearchResponse searchProductByPage(ProductPageSearchRequest request) {
    Assert.isNotNull(request, "搜索商品参数");
    request.validate();
    return post(
        JdVopApiConstant.MAIN_NET_URL + "api/search/search",
        request,
        new TypeReference<Result<ProductPageSearchResponse>>() {});
  }

  /**
   * 查询同类商品
   *
   * @param skuId
   * @return
   */
  public List<ProductSimilar> queryProductSimilar(Long skuId) {
    Assert.isNotNull(skuId, "商品编码");
    return post(
        getUrl() + "getSimilarSku",
        new HashMap<String, Long>(1) {
          {
            put("skuId", skuId);
          }
        },
        new TypeReference<Result<List<ProductSimilar>>>() {});
  }

  /**
   * 查询分类信息
   *
   * @param cid
   * @return
   */
  public Category queryCategory(Long cid) {
    Assert.isNotNull(cid, "分类id");
    return post(
        getUrl() + "getCategory",
        new HashMap<String, Long>(1) {
          {
            put("cid", cid);
          }
        },
        new TypeReference<Result<Category>>() {});
  }

  /**
   * 无货查询推荐商品
   *
   * @param request
   * @return
   */
  public List<Long> queryRecommendProduct(QueryProductRecommendRequest request) {
    Assert.isNotNull(request, "查询商品推荐参数");
    request.validate();
    List<JSONObject> skuIds =
        post(
            JdVopApiConstant.MAIN_NET_URL + "api/stock/stockOutRecommend",
            request,
            new TypeReference<Result<List<JSONObject>>>() {});
    if (CollectionUtils.isEmpty(skuIds)) {
      return null;
    }
    return skuIds.stream()
        .map(data -> data.getLong("skuId"))
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
  }

  /**
   * 商品检查
   *
   * @param request
   * @return
   */
  public List<ProductSaleStateAndStockCheckResponse> productSaleStateAndStockCheck(
      ProductSaleStateAndStockCheckRequest request) {
    Assert.isNotNull(request, "商品上下架状态和库存检查参数");
    request.validate();
    Object result =
        post(
            JdVopApiConstant.MAIN_NET_URL + "api/stock" + "/checkSkuSaleStateAndStock",
            JdProductSaleStateAndStockCheckRequest.builder()
                .area(request.getArea())
                .skuNums(JSON.toJSONString(request.getSkuNums()))
                .build(),
            new TypeReference<Result<Object>>() {});
    if (result == null) {
      return null;
    }
    return JSON.parseObject(
        result.toString(), new TypeReference<List<ProductSaleStateAndStockCheckResponse>>() {});
  }

  /**
   * 查询商品售价
   *
   * @param request
   * @return
   */
  public List<QueryProductSellPriceResponse> queryProductSellPrice(
      QueryProductSellPriceRequest request) {
    Assert.isNotNull(request, "商品售价查询参数");
    request.validate();
    return post(
        JdVopApiConstant.MAIN_NET_URL + "api/price/getSellPrice",
        request,
        new TypeReference<Result<List<QueryProductSellPriceResponse>>>() {});
  }

  /**
   * 查询商品库存
   *
   * @param request
   * @return
   */
  public List<QueryProductStockResponse> queryProductStock(QueryProductStockRequest request) {
    Assert.isNotNull(request, "查询商品库存参数");
    request.validate();
    Object result =
        post(
            JdVopApiConstant.MAIN_NET_URL + "api/stock/getNewStockById",
            JdQueryProductStockRequest.builder()
                .area(request.getArea())
                .skuNums(JSON.toJSONString(request.getSkuNums()))
                .build(),
            new TypeReference<Result<Object>>() {});
    if (result == null) {
      return null;
    }
    return JSON.parseObject(
        result.toString(), new TypeReference<List<QueryProductStockResponse>>() {});
  }
}

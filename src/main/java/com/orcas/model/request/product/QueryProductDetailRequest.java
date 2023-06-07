package com.orcas.model.request.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.orcas.model.request.IValidate;
import com.orcas.util.Assert;
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
public class QueryProductDetailRequest implements Serializable, IValidate {
  public static final Long SERIAL_VERSION_UID = 1L;
  /** 商品编号，只支持单个查询 */
  private String sku;
  /**
   * 以下为商品维度扩展字段，当入参输入某个扩展字段后，出参会返回该字段对应的出参。可以根据需要选用。 nappintroduction //移动端商品详情大字段 nintroduction
   * //PC端商品详情大字段 wxintroduction //微信小程序商品详情大字段，仅提供图片地址，需要客户添加显示逻辑 contractSkuExt
   * //获取客户侧分类编号，需要京东运营维护京东SKU与客户分类编号的映射 isFactoryShip //是否厂直商品 isEnergySaving //是否节能环保商品 taxCode
   * //京东侧税收分类编码 LowestBuy //商品最低起购量 （若要起到下单有限制，需要联系运营有邮件配置） capacity //容量单位转换（例如：油品单位桶转升） spuId
   * //京东侧模拟SPU号 pName //SPU名称 isJDLogistics // "是否京东配送" taxInfo //"商品税率" ChinaCatalog
   * //中国法分类（仅限图书商品使用） contractSkuPoolExt//商品池扩展字段 productFeatures //图书产品特色 seoModel// 规格参数
   * paramDetailJson//获取结构化商品属性数据(同京东官网样式) paramJson//转商详接口出参param为json格式(只解析原出参param) wserve//质保信息
   * isSelf // 是否自营 categoryAttrs // 商品介绍 saleAttr//颜色：color，尺码：size
   * sizeDesc//尺寸描述：长：length、宽：width、高：height preDays//商品最大预占天数，
   */
  @JSONField(name = "queryExts")
  private String params;

  @Override
  public void validate() {
    Assert.isNotBlank(sku, "商品编号");
  }
}

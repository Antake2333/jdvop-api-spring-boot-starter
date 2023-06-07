package com.orcas.model.response.product;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/7
 */
@Data
public class ProductDetail implements Serializable {
  public static final Long SERIAL_VERSION_UID = 1L;
  // 公共
  /** 售卖单位 */
  private String saleUnit;
  /** 重量 */
  private String weight;
  /** 主图 */
  private String imagePath;
  /** 主站上下架状态 (1上架 0下架) */
  private String state;
  /** 品牌名称 */
  private String brandName;
  /** 商品名称 */
  private String name;
  /** 产地 */
  private String productArea;
  /** 商品编号 */
  private String sku;
  /** 分类 示例"670;729;4837" */
  private String category;
  /** 商品详情页大字段 */
  private String introduction;
  // 实物
  /** 包装清单 */
  @JSONField(name = "wareQD")
  private String wareQd;
  /** 规格参数 */
  private String param;
  /** 品牌 */
  @JSONField(name = "Brand")
  private String brand;
  // 图书

  /** 印张 */
  @JSONField(name = "Sheet")
  private String sheet;

  private String relatedProducts;

  /** ISBN */
  @JSONField(name = "ISBN")
  private String isbn;

  /** 编者 */
  @JSONField(name = "Editer")
  private String editer;

  /** 印次 */
  @JSONField(name = "PrintNo")
  private String printNo;

  /** 作者 */
  @JSONField(name = "Author")
  private String author;

  /** 套装数量 */
  @JSONField(name = "PackNum")
  private String packNum;

  private String contentDesc;

  /** 印刷时间 */
  @JSONField(name = "PrintTime")
  private String printTime;

  /** 类型（例book） */
  private String skuType;

  /** 用纸 */
  @JSONField(name = "Papers")
  private String papers;

  /** 包装(装帧) */
  @JSONField(name = "Package")
  private String packageSnipe;

  /** 校对 */
  @JSONField(name = "Proofreader")
  private String proofreader;

  private String editerDesc;
  private String bookAbstract;
  private String catalogue;

  /** 出版时间 */
  @JSONField(name = "PublishTime")
  private String publishTime;

  /** 页数 */
  @JSONField(name = "Pages")
  private String pages;

  private String authorDesc;
  /** 图片 */
  private String image;

  /** 译者 */
  @JSONField(name = "Transfer")
  private String transfer;

  private String appintroduce;

  /** 绘者 */
  @JSONField(name = "Drawer")
  private String drawer;

  /** 图书语言 */
  @JSONField(name = "Language")
  private String language;
  /** 版次 */
  @JSONField(name = "BatchNo")
  private String batchNo;
  /** 图书产品特色，图书类商品introduction可能为空，需要展示此字段作为商品介绍 */
  private String productFeatures;

  private String comments;
  // 音像
  /** 出版社 */
  @JSONField(name = "Press")
  private String press;
  /** 外文名 */
  @JSONField(name = "Foreignname")
  private String foreignName;
  /** 演奏者 */
  @JSONField(name = "Performer")
  private String performer;
  /** 碟数 */
  @JSONField(name = "Soundtrack")
  private String soundtrack;
  /** 演员 区分实物、图书、音像、三种场景 */
  @JSONField(name = "Actor")
  private String actor;
  /** 地区 */
  @JSONField(name = "Dregion")
  private String dregion;
  /** 解说者 */
  @JSONField(name = "Voiceover")
  private String voiceover;
  /** 导演 */
  @JSONField(name = "Director")
  private String director;

  @JSONField(name = "box_Contents")
  private String boxContents;
  /** 字幕语言 */
  @JSONField(name = "Language_Subtitled")
  private String languageSubtitled;
  /** 介质 */
  @JSONField(name = "Media")
  private String media;
  /** 屏幕比例 */
  @JSONField(name = "Screen_Ratio")
  private String screenRatio;
  /** 集数 */
  @JSONField(name = "Episode")
  private String episode;
  /** 文像进字 */
  @JSONField(name = "Mvd_Wxjz")
  private String mvdWxjz;
  /** 发行公司 */
  @JSONField(name = "Publishing_Company")
  private String publishingCompany;
  /** ISRC */
  @JSONField(name = "ISRC")
  private String isrc;
  /** 演唱者 */
  @JSONField(name = "Singer")
  private String singer;
  /** 发音语言 */
  @JSONField(name = "Language_Pronunciation")
  private String languagePronunciation;
  /** 出品公司 */
  @JSONField(name = "Production_Company")
  private String productionCompany;
  /** 音频格式 */
  @JSONField(name = "Audio_Encoding_Chinese")
  private String audioEncodingChinese;
  /** 作词 */
  @JSONField(name = "Authors")
  private String authors;
  /** 又名 */
  @JSONField(name = "Aka")
  private String aka;
  /** 区码 */
  @JSONField(name = "Region")
  private String region;
  /** 版权提供 */
  @JSONField(name = "Copyright")
  private String copyright;
  /** 作曲 */
  @JSONField(name = "Compose")
  private String compose;
  /** 编剧 */
  @JSONField(name = "Screenwriter")
  private String screenwriter;
  /** 配音语言 */
  @JSONField(name = "languageDubbed")
  private String Language_Dubbed;

  private String manual;
  /** 片长 */
  @JSONField(name = "Length")
  private String length;

  @JSONField(name = "material_Description")
  private String materialDescription;
  /** 上映日期 */
  @JSONField(name = "ReleaseDate")
  private String releaseDate;
}

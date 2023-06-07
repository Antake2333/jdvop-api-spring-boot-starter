package com.orcas.model.response.product;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Data
public class ProductPoolDetail implements Serializable {
  public static final long serialVersionUID = 1L;
  /** 商品池名称 */
  private String name;

  /** 商品池编号 */
  @JSONField(name = "page_num")
  private String pageNum;
}

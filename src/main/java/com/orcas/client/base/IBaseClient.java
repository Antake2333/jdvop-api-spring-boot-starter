package com.orcas.client.base;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
public interface IBaseClient {
  /**
   * 获取完整的URL
   *
   * @return url
   */
  String getUrl();
  /**
   * 获取当前URL 没有BaseUrl的
   *
   * @return 基础url
   */
  String getCurrentUrl();
}

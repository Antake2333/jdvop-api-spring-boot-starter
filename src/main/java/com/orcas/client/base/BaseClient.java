package com.orcas.client.base;

import com.dtflys.forest.utils.StringUtils;
import com.orcas.autoconfigure.JdVopProperties;
import com.orcas.constant.JdVopApiConstant;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Data
@Component
public abstract class BaseClient implements IBaseClient {
  @Autowired private JdVopProperties jdVopProperties;

  @Override
  public String getUrl() {
    String currentUrl = getCurrentUrl();
    if (StringUtils.isBlank(currentUrl)) {
      return JdVopApiConstant.MAIN_NET_URL;
    } else {
      return JdVopApiConstant.MAIN_NET_URL
          + (currentUrl.lastIndexOf("/") == currentUrl.length() - 1
              ? currentUrl
              : currentUrl + "/");
    }
  }
}

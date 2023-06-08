package com.orcas.client;

import com.orcas.client.base.SignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description @Author LinLei @Date 2023/6/8
 */
@Component
@Slf4j
public class PriceClient extends SignClient {
  private static final String CURRENT_URL = "api/price/";

  @Override
  public String getCurrentUrl() {
    return CURRENT_URL;
  }
}

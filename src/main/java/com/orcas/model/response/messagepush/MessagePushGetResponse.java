package com.orcas.model.response.messagepush;

import com.alibaba.fastjson.JSONObject;
import com.orcas.model.response.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description @Author LinLei @Date 2023/6/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MessagePushGetResponse extends BaseResponse {
  private Long id;
  private JSONObject result;
  private String time;
  private Integer type;
}

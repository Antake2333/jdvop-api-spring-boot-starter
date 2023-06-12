package com.orcas.model.request.messagepush;

import com.orcas.model.request.BaseRequest;
import com.orcas.model.response.messagepush.MessagePushGetResponse;
import com.orcas.util.Assert;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description @Author LinLei @Date 2023/6/12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MessagePushGetRequest extends BaseRequest<List<MessagePushGetResponse>> {
  /** 消息类型 */
  private List<Integer> messageTypes;

  @Override
  public void validate() {
    Assert.isNotNull(messageTypes, "消息类型");
  }

  @Override
  public Object into() {
    return new HashMap<String, Object>(1) {
      {
        put("type", messageTypes.stream().map(String::valueOf).collect(Collectors.joining(",")));
      }
    };
  }
}

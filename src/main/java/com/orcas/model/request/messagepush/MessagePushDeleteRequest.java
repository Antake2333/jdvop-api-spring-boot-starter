package com.orcas.model.request.messagepush;

import com.alibaba.fastjson.TypeReference;
import com.orcas.model.request.BaseRequest;
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
public class MessagePushDeleteRequest extends BaseRequest<Boolean> {
  /** 消息类型 */
  private List<Long> messageIds;

  @Override
  public void validate() {
    Assert.isNotNull(messageIds, "消息ID列表");
  }

  @Override
  public TypeReference<Boolean> getRespTypeReference() {
    return new TypeReference<Boolean>() {};
  }

  @Override
  public Object into() {
    return new HashMap<String, Object>(1) {
      {
        put("id", messageIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
      }
    };
  }
}

package com.orcas.model;

import lombok.Data;

/**
 * @Description @Author LinLei @Date 2023/6/6
 */
@Data
public class Result<T> {
  /** 具体结果：说明，每个接口都会单独进行说明 */
  private T result;
  /** 错误码 */
  private String resultCode;
  /** 执行结果成功，还是失败 */
  private Boolean success;
  /** 错误描述 */
  private String resultMessage;
}

package com.orcas.exception;

import com.orcas.error.ErrorCode;
import com.orcas.error.JdVopApiError;

/**
 * @author Orcas
 * @date 2022/10/22
 */
public class JdVopApi4jException extends RuntimeException {

  private int code;

  public JdVopApi4jException() {}

  public JdVopApi4jException(int code, String message) {
    super(message);
    this.code = code;
  }

  public JdVopApi4jException(String message) {
    super(message);
    this.code = JdVopApiError.SYSTEM_ERROR.getCode();
  }

  public JdVopApi4jException(ErrorCode errorCode) {
    super(errorCode.getMsg());
    this.code = errorCode.getCode();
  }

  public JdVopApi4jException(ErrorCode errorCode, Throwable throwable) {
    super(errorCode.getMsg(), throwable);
    this.code = errorCode.getCode();
  }

  public static JdVopApi4jException paramError(String msg) {
    return new JdVopApi4jException(JdVopApiError.PARAMETER_ERROR.getCode(), msg);
  }

  public static JdVopApi4jException paramError(Integer code, String msg) {
    return new JdVopApi4jException(code, msg);
  }

  public int getCode() {
    return code;
  }
}

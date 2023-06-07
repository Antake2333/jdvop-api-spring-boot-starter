package com.orcas.error;

/**
 * @author yansong
 * @date 2022-06-21 12:26
 **/
public enum JdVopApiError implements ErrorCode {

    JSON_FORMAT_ERR(400, "请求参数JSON格式错误"),
    SYSTEM_ERROR(500, "系统异常"),
    PARAMETER_ERROR(600, "参数错误"),
    JD_VOP_ERROR(1000, "JD_VOP异常"),
    ;

    private int code;

    private String msg;

    JdVopApiError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}

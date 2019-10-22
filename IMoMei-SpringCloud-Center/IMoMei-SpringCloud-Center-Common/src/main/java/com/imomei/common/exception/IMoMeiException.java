package com.imomei.common.exception;

/***
 * 全局异常类
 */
public class IMoMeiException extends RuntimeException {

    // 异常状态码
    private Integer code;
    // 异常信息
    private String msg;

    public IMoMeiException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

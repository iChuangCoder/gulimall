package com.ichuang.common.enu;

public enum ExceptionEnum {
    UnKnowException(10000,"系统未知异常"),
    MethodArgumentNotValidException(10001,"参数异常");

    private int code;
    private String msg;
    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

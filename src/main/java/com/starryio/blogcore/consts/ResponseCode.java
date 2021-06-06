package com.starryio.blogcore.consts;

/**
 * 错误代码枚举类
 */
public enum ResponseCode {

    success("200","ok"),

    e400("400", "Bad Request! 不应该出现的请求"),
    e403("403", "Forbidden! 权限不足"),
    e404("404", "not found! 无法找到对应资源"),
    e500("500", "unexpected error! 意外错误，请联系管理员"),
    e555("555","undefined error! 普通的错误");

    private final String code;
    private final String msg;

    ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode(){
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

}

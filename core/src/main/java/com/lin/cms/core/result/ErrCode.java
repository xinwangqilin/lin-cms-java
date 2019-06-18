package com.lin.cms.core.result;


/**
 * 错误码
 */
public enum ErrCode {

    SUCCESS(0, "成功"),

    FAIL(9999, "失败"),

    UNAUTHORIZED(10000, "认证失败"),

    NOT_FOUND(10020, "资源不存在"),

    PARAMETER_ERROR(10030, "参数错误"),

    INTERNAL_SERVER_ERROR(999, "服务器内部错误"),

    FORBIDDEN(10070, "禁止操作");

    private int code;
    private String description;

    ErrCode(int code, String description) {
        // HttpStatus
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }}

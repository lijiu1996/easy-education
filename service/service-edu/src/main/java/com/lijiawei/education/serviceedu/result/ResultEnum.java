package com.lijiawei.education.serviceedu.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultEnum {

    SUCCESS(200,"success"),
    // 400系列
    BAD_REQUEST(400,"请求的数据格式不符"),
    UNAUTHORIZED(401,"登录凭证过期"),
    FORBIDDEN(403,"没有请求权限"),
    NOT_FOUND(404,"请求资源不存在"),

    // 500系列
    INTERNAL_ERROR(500,"内部错误"),

    // customize
    UNKNOWN_ERROR(10000,"未知异常"),
    USER_NAME_NOT_NULL(10001,"用户名不能为空");

    private final int code;
    private final String msg;
}

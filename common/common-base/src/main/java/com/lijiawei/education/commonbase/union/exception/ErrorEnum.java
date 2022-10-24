package com.lijiawei.education.commonbase.union.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Li JiaWei
 * @ClassName: ErrorEnum
 * @Description:
 * @Date: 2022/10/24 14:48
 * @Version: 1.0
 */
@AllArgsConstructor
@Getter
public enum ErrorEnum {

    //自定义
    UNKNOWN(10000,"未知异常"),
    INVALID_INPUT(10001,"参数校验异常"),

    SUCCESS(200,"OK"),
    //400系列
    BAD_REQUEST(400,"请求的数据格式不符!"),
    UNAUTHORIZED(401,"登录凭证过期!"),
    FORBIDDEN(403,"抱歉，你无权限访问!"),
    NOT_FOUND(404, "请求的资源找不到!"),

    //500系列
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVICE_UNAVAILABLE(503,"服务器正忙，请稍后再试!");

    private int code;
    private String msg;
}

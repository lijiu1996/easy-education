package com.lijiawei.education.serviceedu.result;

import lombok.Getter;

/**
 * 1.统一返回结果类  -- 返回结果中携带int类型的状态码信息
 *                   String类型的msg信息
 * 2.统一返回结果类 可以从 ResponseEnum 构建
 *                也可以从 增强的自定义异常类 构建(增强的自定义异常类携带有属性 code 以及 msg)
 * 3.也可以将这个类抽象出来 继承一个接口 这样返回类型可以在注解那里随意替换
 * @param <T>
 */
@Getter
public class Result<T> implements IResult<T> {

    private boolean success;
    private int code;
    private String msg;
    private T data;

    private Result() { }

    // 不开放构造函数
    private Result(boolean success, int code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(true, ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

    public static Result error(String msg) {
        return new Result<>(false,ResultEnum.BAD_REQUEST.getCode(), ResultEnum.BAD_REQUEST.getMsg(), msg);
    }


    public Result<T> success(int code, String msg, T data) {
        return new Result<>(true, code, msg, data);
    }

    public Result<T> fail(int code, String msg) {
        return new Result<>(false, code, msg, null);
    }

    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}

package com.lijiawei.education.serviceedu.result;

/**
 *  抽象返回接口 在UnionResponse中实现自定义返回类型
 */
public interface IResult<T> {

//    IResult success(int code, String msg, T data);
//
//    IResult fail(int code, String msg);

    IResult setCode(int code);

    IResult setMsg(String msg);

    IResult setSuccess(boolean success);

    IResult setData(T data);
}

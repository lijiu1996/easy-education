package com.lijiawei.education.serviceedu.result;

import lombok.Getter;

/**
 *  通过UnionResponse实现返回类型自定义 -- 携带的值需要包含code和msg
 */
@Getter
public class ResultElse<T> implements IResult<T> {

    private boolean success;
    private int returnCode;
    private String returnDesc;
    private T data;

    private ResultElse() {
    }

    private ResultElse(boolean success, int returnCode, String returnDesc, T data) {
        this.success = success;
        this.returnCode = returnCode;
        this.returnDesc = returnDesc;
        this.data = data;
    }

    @Override
    public IResult setCode(int code) {
        this.returnCode = code;
        return this;
    }

    @Override
    public IResult setMsg(String msg) {
        this.returnDesc = msg;
        return this;
    }

    @Override
    public IResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    @Override
    public IResult setData(T data) {
        this.data = data;
        return this;
    }
}

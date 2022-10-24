package com.lijiawei.education.commonbase.union.result;

import com.lijiawei.education.commonbase.union.exception.BusinessException;
import com.lijiawei.education.commonbase.union.exception.ErrorEnum;
import lombok.Data;

/**
 * @author Li JiaWei
 * @ClassName: Result
 * @Description:
 * @Date: 2022/10/24 15:18
 * @Version: 1.0
 */
@Data
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    private Result()  {
    }

    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result error(BusinessException e) {
        return new Result(e.getCode(),e.getMsg());
    }

    public static Result error(ErrorEnum errorEnum) {
        return new Result(errorEnum.getCode(),errorEnum.getMsg());
    }

    public static Result build(int code, String msg) {
        return new Result(code,msg);
    }

    public static <T> Result ok(T data) {
        return new Result(ErrorEnum.SUCCESS.getCode(), ErrorEnum.SUCCESS.getMsg(),data);
    }

    public static <T> Result build(int code, String msg, T data) {
        return new Result(code,msg,data);
    }

    public static Result ok() {
        return new Result(ErrorEnum.SUCCESS.getCode(), ErrorEnum.SUCCESS.getMsg());
    }
}

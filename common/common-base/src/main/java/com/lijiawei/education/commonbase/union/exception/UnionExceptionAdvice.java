package com.lijiawei.education.commonbase.union.exception;

import com.lijiawei.education.commonbase.union.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Li JiaWei
 * @ClassName: UnionExceptionAdvice
 * @Description:    全局异常捕捉
 * @Date: 2022/10/24 11:04
 * @Version: 1.0
 */
@Slf4j
@RestControllerAdvice
public class UnionExceptionAdvice {

    @ExceptionHandler(Throwable.class)
    public Result exceptionHandler(Throwable e) {
        log.error(e.getMessage(),e);
        return Result.build(ErrorEnum.UNKNOWN.getCode(),e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result businessHandler(BusinessException e){
        log.error(e.getMsg(),e);
        return Result.error(e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        ObjectError error = e.getBindingResult().getAllErrors().get(0);
        return Result.build(ErrorEnum.INVALID_INPUT.getCode(),error.getDefaultMessage());
    }
}

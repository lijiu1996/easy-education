package com.lijiawei.education.serviceedu.result;

import java.lang.annotation.*;

/**
 *  利用注解进行统一返回处理
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UnionResponse {

    int code() default 200;
    String msg() default "success";
    Class<? extends IResult> resultClass() default Result.class;
}

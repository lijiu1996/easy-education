package com.lijiawei.education.commonbase.union.result;

import com.lijiawei.education.commonbase.union.exception.ErrorEnum;

import java.lang.annotation.*;

/**
 * @author Li JiaWei
 * @ClassName: AnnoResult
 * @Description: 按照统一格式返回结果
 * @Date: 2022/10/24 15:44
 * @Version: 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UnionResponse {

    ErrorEnum errorType() default ErrorEnum.SUCCESS;
    int resCode() default 200;
    String resMessage() default "OK";

}

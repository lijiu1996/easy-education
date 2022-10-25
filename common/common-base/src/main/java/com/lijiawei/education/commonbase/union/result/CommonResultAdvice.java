package com.lijiawei.education.commonbase.union.result;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lijiawei.education.commonbase.union.exception.ErrorEnum;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * @author Li JiaWei
 * @ClassName: CommonResultAdvice
 * @Description:
 * @Date: 2022/10/24 11:02
 * @Version: 1.0
 */
@Slf4j
@RestControllerAdvice
public class CommonResultAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.hasMethodAnnotation(UnionResponse.class)
                || returnType.getContainingClass().isAnnotationPresent(UnionResponse.class);
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Result)
            return body;
        else if (body instanceof String) {
            return new ObjectMapper().writeValueAsString(Result.ok(body));
        } else {
            UnionResponse annotation = returnType.getMethodAnnotation(UnionResponse.class);
            // 注解可能在方法上或者直接在类上
            if (annotation == null) {
                annotation = returnType.getContainingClass().getAnnotation(UnionResponse.class);
            }
            ErrorEnum errorEnum = annotation.errorType();
            if (errorEnum.equals(ErrorEnum.SUCCESS)) {
                return Result.ok(body);
            } else if (errorEnum.equals(ErrorEnum.UNKNOWN)){
                return Result.build(annotation.resCode(),annotation.resMessage(),null);
            } else {
                return Result.error(errorEnum);
            }
        }
    }


}

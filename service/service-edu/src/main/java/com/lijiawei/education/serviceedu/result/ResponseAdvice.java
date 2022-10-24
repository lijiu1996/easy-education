package com.lijiawei.education.serviceedu.result;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 对返回结果实现增强
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        Method method = returnType.getMethod();
        return method.isAnnotationPresent(UnionResponse.class);
    }

    /**
     *  根据不同返回类型处理结果
     *      1. 本身就是result类型
     *      2. String 类型
     *      3. 注解自定义类型
     */
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof IResult)
            return body;
        else if (body instanceof String) {
            return new ObjectMapper().writeValueAsString(Result.success(body));
        }
        else {
            UnionResponse methodAnnotation = returnType.getMethodAnnotation(UnionResponse.class);
            Class<? extends IResult> res = methodAnnotation.resultClass();
//            Method success = res.getMethod("success", int.class, String.class, Object.class);
//            return success.invoke(null,methodAnnotation.code(), methodAnnotation.msg(), body);
            Constructor<? extends IResult> constructor = res.getDeclaredConstructor();
            constructor.setAccessible(true);
            IResult iResult = constructor.newInstance();
            iResult.setSuccess(true).setCode(methodAnnotation.code()).setMsg(methodAnnotation.msg()).setData(body);
            return iResult;
        }
    }
}

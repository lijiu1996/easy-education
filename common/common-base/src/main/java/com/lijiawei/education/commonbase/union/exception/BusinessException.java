package com.lijiawei.education.commonbase.union.exception;

import lombok.Data;

/**
 * @author Li JiaWei
 * @ClassName: BusinessException
 * @Description:
 * @Date: 2022/10/24 11:05
 * @Version: 1.0
 */

@Data
public class BusinessException extends RuntimeException{

    private Integer code;
    private String msg;

    public BusinessException(String message, Integer code) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public static BusinessException of(ErrorEnum errorEnum) {
        return new BusinessException(errorEnum.getMsg(),errorEnum.getCode());
    }
}

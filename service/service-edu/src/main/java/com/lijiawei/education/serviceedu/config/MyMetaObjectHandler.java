package com.lijiawei.education.serviceedu.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Li JiaWei
 * @ClassName: MyMetaObjectHandler
 * @Description: mybatis-plus 自动填充功能
 * @Date: 2022/10/25 11:00
 * @Version: 1.0
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.debug("开始执行自动填充insert代码");
        this.strictInsertFill(metaObject,"gmtCreate", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject,"gmtModified",LocalDateTime.class,LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("开始执行自动填充update代码");
        this.strictUpdateFill(metaObject,"gmtModified",LocalDateTime.class, LocalDateTime.now());
    }
}

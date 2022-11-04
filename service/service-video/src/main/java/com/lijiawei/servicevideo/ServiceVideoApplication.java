package com.lijiawei.servicevideo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Li JiaWei
 * @ClassName: ServiceVideoApplication
 * @Description:    集成视频功能组件
 * @Date: 2022/11/4 9:35
 * @Version: 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ServiceVideoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVideoApplication.class,args);
    }
}

package com.lijiawei.education.serviceoss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Li JiaWei
 * @ClassName: ServiceOssApplication
 * @Description:
 * @Date: 2022/11/2 10:55
 * @Version: 1.0
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.lijiawei.education.serviceoss",
    "com.lijiawei.education.commonbase"})
public class ServiceOssApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOssApplication.class,args);
    }
}

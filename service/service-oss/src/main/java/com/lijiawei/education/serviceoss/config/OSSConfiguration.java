package com.lijiawei.education.serviceoss.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Li JiaWei
 * @ClassName: OSSConfiguration
 * @Description:
 * @Date: 2022/11/2 11:47
 * @Version: 1.0
 */
@ConfigurationProperties("aliyun.oss.file")
@Configuration
@Data
public class OSSConfiguration {

    private String endpoint;
    private String keyid;
    private String keysecret;
    private String bucketname;
}

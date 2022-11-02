package com.lijiawei.education.serviceoss.service;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.lijiawei.education.serviceoss.config.OSSConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @author Li JiaWei
 * @ClassName: OSSService
 * @Description:
 * @Date: 2022/11/2 13:58
 * @Version: 1.0
 */
@Slf4j
@Service
public class OSSService {

    private final OSSConfiguration ossConfiguration;

    public OSSService(OSSConfiguration ossConfiguration) {
        this.ossConfiguration = ossConfiguration;
    }

    public String uploadAvatar(MultipartFile file) {
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(ossConfiguration.getEndpoint(), ossConfiguration.getKeyid(), ossConfiguration.getKeysecret());
        try {
            String content = "Hello OSS";
            // 文件名 首先要区分用户 时间 支持重复提交
            String fileName = UUID.randomUUID().toString();
            String originalFilename = file.getOriginalFilename();
            String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 用日期分割文件夹
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("/YYYY/MM/dd/");
            String time = formatter.format(LocalDateTime.now());
            String newName = "photo" + time + fileName + fileType;
            ossClient.putObject(ossConfiguration.getBucketname(), newName,file.getInputStream());
            String uploadUrl = "https://" + ossConfiguration.getBucketname() + "." + ossConfiguration.getEndpoint() + "/" + newName;
            return uploadUrl;
        } catch (OSSException oe) {
            log.info("Caught an OSSException, which means your request made it to OSS, \"\n" +
                    "                    + \"but was rejected with an error response for some reason.");
            log.info("Error Message:{}",oe.getErrorMessage());
            log.info("Error Code:{}",oe.getErrorCode());
            log.info("Request ID:{}",oe.getRequestId());
            log.info("Host ID:{}",oe.getHostId());
        } catch (IOException ie) {
            log.info("Caught an IOException, {}", ie.getMessage());
        } catch (ClientException ce) {
            log.info("Caught an ClientException, which means the client encountered \"\n" +
                    "                    + \"a serious internal problem while trying to communicate with OSS, \"\n" +
                    "                    + \"such as not being able to access the network.");
            log.info("Error Message:{}",ce.getMessage());
        } finally {
            if (ossClient != null)
                ossClient.shutdown();
        }

        return null;
    }
}

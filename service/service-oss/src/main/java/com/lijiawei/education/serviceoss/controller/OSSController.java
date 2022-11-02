package com.lijiawei.education.serviceoss.controller;

import com.lijiawei.education.commonbase.union.exception.BusinessException;
import com.lijiawei.education.commonbase.union.result.UnionResponse;
import com.lijiawei.education.serviceoss.config.OSSConfiguration;
import com.lijiawei.education.serviceoss.service.OSSService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Li JiaWei
 * @ClassName: OSSController
 * @Description:
 * @Date: 2022/11/2 11:09
 * @Version: 1.0
 */
@RestController
@UnionResponse
@CrossOrigin
@RequestMapping("/service_oss/")
@Api(tags = "云存储访问接口")
public class OSSController {

    private final OSSService ossService;

    public OSSController(OSSService ossService) {
        this.ossService = ossService;
    }

    // 1. 文件上传功能实现
    @ApiOperation("文件上传功能")
    @PostMapping("upload")
    public String avatarUpload(MultipartFile file) {
        String fileUrl = ossService.uploadAvatar(file);
        if (fileUrl == null) {
            throw new BusinessException("文件保存失败",500);
        }
        return fileUrl;
    }

}

package com.lijiawei.education.serviceedu.controller;

import com.alibaba.excel.EasyExcel;
import com.lijiawei.education.commonbase.union.result.UnionResponse;
import com.lijiawei.education.serviceedu.service.ISubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-27
 */
@Slf4j
@Api(tags = "课程分类管理")
@RestController
@RequestMapping("/service_edu/subject")
@CrossOrigin
@UnionResponse
public class SubjectController {

    private final ISubjectService subjectService;

    public SubjectController(ISubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @SneakyThrows
    @ApiOperation("上传excel格式数据插入到数据库")
    @PostMapping("/file")
    public boolean addCourseType(MultipartFile file) {
        subjectService.addSubjectTable(file);
        return true;
    }



}

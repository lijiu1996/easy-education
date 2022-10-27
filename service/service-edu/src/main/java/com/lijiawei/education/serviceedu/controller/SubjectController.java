package com.lijiawei.education.serviceedu.controller;

import com.lijiawei.education.commonbase.union.result.UnionResponse;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/serviceedu/subject")
@CrossOrigin
@UnionResponse
public class SubjectController {

}

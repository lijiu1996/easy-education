package com.lijiawei.education.serviceedu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijiawei.education.serviceedu.entity.Teacher;
import com.lijiawei.education.serviceedu.result.Result;
import com.lijiawei.education.serviceedu.result.ResultElse;
import com.lijiawei.education.serviceedu.result.UnionResponse;
import com.lijiawei.education.serviceedu.service.impl.TeacherServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-11
 */
@Api("讲师管理")
@RestController
@RequestMapping("/service_edu/teacher")
public class TeacherController {

    private final TeacherServiceImpl teacherService;

    public TeacherController(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    @ApiOperation("所有讲师列表")
    @GetMapping
    @UnionResponse(code = 199,msg = "返回成昆",resultClass = ResultElse.class)
    public List<Teacher> list() {
        return teacherService.list();
    }

    @ApiOperation("根据ID删除讲师")
    @DeleteMapping("{id}")
    @UnionResponse(code = 201,msg = "返回成昆啦")
    public boolean removeById(
            @ApiParam(name = "id", value = "讲师ID")
            @PathVariable String id) {
        return teacherService.removeById(id);
    }

    @ApiOperation("分页查询讲师列表")
    @GetMapping("/page/{current}/{total}")
    @UnionResponse
    public List<Teacher> listPage(@PathVariable long current,
                                  @PathVariable long total) {
        Page<Teacher> page = new Page<>(current,total);
        teacherService.page(page);
        List<Teacher> records = page.getRecords();
        return records;
    }

}

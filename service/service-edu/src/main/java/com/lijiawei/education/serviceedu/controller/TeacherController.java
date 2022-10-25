package com.lijiawei.education.serviceedu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijiawei.education.commonbase.union.result.UnionResponse;
import com.lijiawei.education.serviceedu.entity.Teacher;
import com.lijiawei.education.serviceedu.service.impl.TeacherServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = "讲师管理")
@RestController
@RequestMapping("/service_edu/teacher")
@UnionResponse
public class TeacherController {

    private final TeacherServiceImpl teacherService;

    public TeacherController(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    @ApiOperation("所有讲师列表")
    @GetMapping
    public List<Teacher> list() {
        return teacherService.list();
    }

    @ApiOperation("查询单个讲师")
    @GetMapping("/{id}")
    public Teacher one(@PathVariable long id) {
        return teacherService.getById(id);
    }

    @ApiOperation("分页查询讲师列表")
    @GetMapping("/page/{current}/{total}")
    public List<Teacher> listPage(@PathVariable long current,
                                  @PathVariable long total) {
        Page<Teacher> page = new Page<>(current,total);
        teacherService.page(page);
        List<Teacher> records = page.getRecords();
        return records;
    }

//    @ApiOperation("添加讲师")
//    @PostMapping
//    public boolean add(Teacher teacher) {
//        return teacherService.save(teacher);
//    }
//
//    @ApiOperation("修改讲师")
//    @PutMapping
//    public boolean update(Teacher teacher) {
//        return teacherService.update()
//    }

    @ApiOperation("根据ID删除讲师")
    @DeleteMapping("{id}")
    public boolean removeById(
            @ApiParam(name = "id", value = "讲师ID")
            @PathVariable String id) {
        return teacherService.removeById(id);
    }


}

package com.lijiawei.education.serviceedu.controller;

import com.lijiawei.education.commonbase.union.result.UnionResponse;
import com.lijiawei.education.serviceedu.entity.dto.CourseDTO;
import com.lijiawei.education.serviceedu.entity.dto.CourseQueryDTO;
import com.lijiawei.education.serviceedu.entity.po.Course;
import com.lijiawei.education.serviceedu.entity.po.CourseDescription;
import com.lijiawei.education.serviceedu.service.ICourseDescriptionService;
import com.lijiawei.education.serviceedu.service.ICourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-31
 */
@Api(tags = "课程管理")
@RestController
@RequestMapping("/service_edu/course")
@UnionResponse
@CrossOrigin
public class CourseController {

    private final ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    //1. getById
    @ApiOperation("根据id查询课程")
    @GetMapping("{id}")
    public CourseDTO getById(@PathVariable String id) {
        return courseService.getCourseInfoById(id);
    }

    //2. getList
    @ApiOperation("查询课程列表")
    @GetMapping("list")
    public List<CourseDTO> getList() {
        List<Course> list = courseService.list();
        return null;
    }

    //3. getByCondition
    @ApiOperation("条件查询")
    @PostMapping("list")
    public List<CourseDTO> getListByCondition(@RequestBody CourseQueryDTO courseQueryDTO) {
        return null;
    }

    //4. add
    @ApiOperation("增加课程")
    @PostMapping
    public String addCourse(@RequestBody CourseDTO course) {
        String id = courseService.addCourse(course);
        return id;
    }

    //5. update
    @ApiOperation("更新课程")
    @PutMapping
    public boolean updateCourse(@RequestBody CourseDTO course) {
        courseService.updateCourse(course);
        return false;
    }

    //6. delete
    @ApiOperation("删除课程")
    @DeleteMapping("{id}")
    // TODO : 删除课程需要同步删除几张表信息 如简介表 章节表
    public boolean deleteCourse(@PathVariable String id) {
        boolean b = courseService.removeById(id);
        return b;
    }



}

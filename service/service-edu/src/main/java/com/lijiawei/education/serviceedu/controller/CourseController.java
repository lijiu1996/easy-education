package com.lijiawei.education.serviceedu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijiawei.education.commonbase.union.result.UnionResponse;
import com.lijiawei.education.serviceedu.entity.dto.CourseDTO;
import com.lijiawei.education.serviceedu.entity.dto.CourseListDTO;
import com.lijiawei.education.serviceedu.entity.dto.CoursePreviewDTO;
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
    @PostMapping("page/{current}/{total}")
    public CourseListDTO getListByCondition(@PathVariable long current, @PathVariable long total, @RequestBody CourseQueryDTO courseQueryDTO) {
        LambdaQueryWrapper<Course> lqw = null;
        if (courseQueryDTO != null) {
            lqw = new LambdaQueryWrapper<>();
            String title = courseQueryDTO.getTitle();
            String state = courseQueryDTO.getState();
            if (title != null) {
                lqw.like(Course::getTitle,title);
            }
            if (state != null) {
                lqw.eq(Course::getStatus,state);
            }
        }
        Page<Course> page = new Page<>(current,total);
        courseService.page(page,lqw);
        return new CourseListDTO(page.getRecords());
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
        return courseService.removeCourseById(id);
    }

    //7. 根据课程id查询课程预览信息作确认
    @ApiOperation("查询课程预览信息")
    @GetMapping("preview/{id}")
    public CoursePreviewDTO getPreviewById(@PathVariable String id) {
        return courseService.getPreview(id);
    }

    //8. 发布课程
    @ApiOperation("发布课程")
    @PutMapping("publish/{id}")
    public boolean publishCourse(@PathVariable String id) {
        return courseService.publishById(id);
    }
}

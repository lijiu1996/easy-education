package com.lijiawei.education.serviceedu.service;

import com.lijiawei.education.serviceedu.entity.dto.CourseDTO;
import com.lijiawei.education.serviceedu.entity.po.Course;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-31
 */
public interface ICourseService extends IService<Course> {

    String addCourse(CourseDTO course);

    void updateCourse(CourseDTO course);

    CourseDTO getCourseInfoById(String id);
}

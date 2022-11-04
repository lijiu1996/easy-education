package com.lijiawei.education.serviceedu.service;

import com.lijiawei.education.serviceedu.entity.dto.CourseDTO;
import com.lijiawei.education.serviceedu.entity.dto.CourseListDTO;
import com.lijiawei.education.serviceedu.entity.dto.CoursePreviewDTO;
import com.lijiawei.education.serviceedu.entity.dto.CourseQueryDTO;
import com.lijiawei.education.serviceedu.entity.po.Course;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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

    CoursePreviewDTO getPreview(String id);

    boolean publishById(String id);

    boolean removeCourseById(String id);
}

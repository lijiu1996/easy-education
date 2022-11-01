package com.lijiawei.education.serviceedu.service.impl;

import com.lijiawei.education.commonbase.union.exception.BusinessException;
import com.lijiawei.education.serviceedu.entity.dto.CourseDTO;
import com.lijiawei.education.serviceedu.entity.po.Course;
import com.lijiawei.education.serviceedu.entity.po.CourseDescription;
import com.lijiawei.education.serviceedu.mapper.CourseMapper;
import com.lijiawei.education.serviceedu.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-31
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    private final CourseDescriptionServiceImpl courseDescriptionService;

    public CourseServiceImpl(CourseDescriptionServiceImpl courseDescriptionService) {
        this.courseDescriptionService = courseDescriptionService;
    }

    @Override
    public String addCourse(CourseDTO courseDTO) {
        Course course = new Course();
        BeanUtils.copyProperties(courseDTO,course);
        boolean save = this.save(course);
        if (!save) {
            throw new BusinessException("保存课程失败",500);
        }
        CourseDescription description = new CourseDescription();
        description.setId(course.getId());
        description.setDescription(courseDTO.getDescription());
        boolean save1 = courseDescriptionService.save(description);
        if (!save1) {
            throw new BusinessException("保存课程简介失败",500)
        }
        return course.getId();
    }

    /**
     * 修改课程信息
     * @param course
     * @return
     */
    @Override
    public String updateCourse(CourseDTO course) {
        return ;
    }
}

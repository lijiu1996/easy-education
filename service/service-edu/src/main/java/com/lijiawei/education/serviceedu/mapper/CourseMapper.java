package com.lijiawei.education.serviceedu.mapper;

import com.lijiawei.education.serviceedu.entity.dto.CoursePreviewDTO;
import com.lijiawei.education.serviceedu.entity.po.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-31
 */
public interface CourseMapper extends BaseMapper<Course> {
    CoursePreviewDTO getPreviewById(String id);
}

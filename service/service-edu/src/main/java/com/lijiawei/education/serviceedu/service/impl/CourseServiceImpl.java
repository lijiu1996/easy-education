package com.lijiawei.education.serviceedu.service.impl;

import com.lijiawei.education.commonbase.union.exception.BusinessException;
import com.lijiawei.education.serviceedu.entity.dto.CourseDTO;
import com.lijiawei.education.serviceedu.entity.dto.CourseListDTO;
import com.lijiawei.education.serviceedu.entity.dto.CoursePreviewDTO;
import com.lijiawei.education.serviceedu.entity.dto.CourseQueryDTO;
import com.lijiawei.education.serviceedu.entity.po.Course;
import com.lijiawei.education.serviceedu.entity.po.CourseDescription;
import com.lijiawei.education.serviceedu.mapper.CourseMapper;
import com.lijiawei.education.serviceedu.service.IChapterService;
import com.lijiawei.education.serviceedu.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lijiawei.education.serviceedu.service.IVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private final IChapterService chapterService;

    private final IVideoService videoService;

    public CourseServiceImpl(CourseDescriptionServiceImpl courseDescriptionService, IChapterService chapterService, IVideoService videoService) {
        this.courseDescriptionService = courseDescriptionService;
        this.chapterService = chapterService;
        this.videoService = videoService;
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
            throw new BusinessException("保存课程简介失败",500);
        }
        return course.getId();
    }

    /**
     * 修改课程信息
     * @param courseDTO
     */
    @Override
    public void updateCourse(CourseDTO courseDTO) {
        Course course = new Course();
        BeanUtils.copyProperties(courseDTO,course);
        boolean b = this.updateById(course);
        if (!b) {
            throw new BusinessException("课程信息保存失败",500);
        }
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseDTO.getDescription());
        courseDescription.setId(courseDTO.getId());
        boolean resultDescription = courseDescriptionService.updateById(courseDescription);
        if (!resultDescription) {
            throw new BusinessException("课程详情信息保存失败",500);
        }
    }

    @Override
    public CourseDTO getCourseInfoById(String id) {
        CourseDTO courseDTO = new CourseDTO();
        Course course = this.getById(id);
        if (course == null) {
            throw new BusinessException("课程数据不存在",20001);
        }
        BeanUtils.copyProperties(course,courseDTO);
        CourseDescription courseDescription = courseDescriptionService.getById(id);
        courseDTO.setDescription(courseDescription.getDescription());
        return courseDTO;
    }

    @Override
    public CoursePreviewDTO getPreview(String id) {
        return baseMapper.getPreviewById(id);
    }

    @Override
    public boolean publishById(String id) {
        Course course = new Course();
        course.setId(id);
        course.setStatus(Course.STATUS_PUBLISHED);
        return baseMapper.updateById(course) > 0;
    }

    // 根据id联合删除课程表章节表课程简介表中的值
    @Override
    public boolean removeCourseById(String id) {
        // 删除课程章节和小节信息
//        videoService.deleteByCourseIdForce(id);
        chapterService.deleteByCourseIdForce(id);
        // 删除课程简介信息
        courseDescriptionService.removeById(id);
        // 删除课程信息
        this.removeById(id);
        return true;
    }

}

package com.lijiawei.education.serviceedu.entity.dto;

import com.lijiawei.education.serviceedu.entity.po.Course;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Li JiaWei
 * @ClassName: CourseListDTO
 * @Description:
 * @Date: 2022/11/4 11:04
 * @Version: 1.0
 */
@AllArgsConstructor
@Data
public class CourseListDTO {

    private List<Course> courseList;
    private Integer totalCount;

    public CourseListDTO(List<Course> courseList) {
        this.courseList = courseList;
        this.totalCount = courseList.size();
    }
}

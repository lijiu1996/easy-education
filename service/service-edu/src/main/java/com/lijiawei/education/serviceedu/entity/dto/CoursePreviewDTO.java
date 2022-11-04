package com.lijiawei.education.serviceedu.entity.dto;

import lombok.Data;

/**
 * @author Li JiaWei
 * @ClassName: CoursePreviewDTO
 * @Description:
 * @Date: 2022/11/3 23:01
 * @Version: 1.0
 */

@Data
public class CoursePreviewDTO {

    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示
}

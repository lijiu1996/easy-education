package com.lijiawei.education.serviceedu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 课程简介
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-31
 */
@Getter
@Setter
@TableName("edu_course_description")
@ApiModel(value = "CourseDescription对象", description = "课程简介")
public class CourseDescription implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("课程ID")
    private String id;

    @ApiModelProperty("课程简介")
    private String description;

    @ApiModelProperty("创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty("更新时间")
    private LocalDateTime gmtModified;


}

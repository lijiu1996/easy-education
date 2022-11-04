package com.lijiawei.education.serviceedu.entity.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Li JiaWei
 * @ClassName: CourseDTO
 * @Description:    返回给前端的课程信息组合
 * @Date: 2022/10/31 14:57
 * @Version: 1.0
 */
@Data
@ApiModel("前台展示课程信息")
public class CourseDTO {

    @ApiModelProperty("课程ID")
    private String id;

    @ApiModelProperty("课程讲师ID")
    private String teacherId;

    @ApiModelProperty("课程专业ID")
    private String subjectId;

    @ApiModelProperty("课程专业父级ID")
    private String subjectParentId;

    @ApiModelProperty("课程标题")
    private String title;

    @ApiModelProperty("课程销售价格，设置为0则可免费观看")
    private BigDecimal price;

    @ApiModelProperty("总课时")
    private Integer lessonNum;

    @ApiModelProperty("课程封面图片路径")
    private String cover;

    @ApiModelProperty("课程状态 Draft未发布  Normal已发布")
    private String status;

    @ApiModelProperty("课程简介")
    private String description;
}

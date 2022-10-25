package com.lijiawei.education.serviceedu.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TeacherQueryVO {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2初级讲师")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间")
    private String begin;

    @ApiModelProperty(value = "查询结束时间")
    private String end;
}

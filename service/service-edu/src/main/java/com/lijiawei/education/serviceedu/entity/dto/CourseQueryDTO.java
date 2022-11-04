package com.lijiawei.education.serviceedu.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @author Li JiaWei
 * @ClassName: CourseQueryDTO
 * @Description:
 * @Date: 2022/10/31 15:19
 * @Version: 1.0
 */
@Data
@ApiModel("课程查询条件")
public class CourseQueryDTO {

    @ApiModelProperty("课程名称")
    private String title;

    @ApiModelProperty("课程状态")
    private String state;
}

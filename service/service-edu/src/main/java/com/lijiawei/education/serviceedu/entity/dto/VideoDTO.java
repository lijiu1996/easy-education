package com.lijiawei.education.serviceedu.entity.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Li JiaWei
 * @ClassName: VideoDTO
 * @Description:
 * @Date: 2022/11/3 13:49
 * @Version: 1.0
 */
@Data
@ApiModel("前台展示课程小节信息")
public class VideoDTO {

    private String id;
    private String title;
    private Boolean free;
}

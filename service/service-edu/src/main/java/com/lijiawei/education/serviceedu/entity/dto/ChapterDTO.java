package com.lijiawei.education.serviceedu.entity.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li JiaWei
 * @ClassName: ChapterDTO
 * @Description:
 * @Date: 2022/11/3 13:49
 * @Version: 1.0
 */
@Data
@ApiModel("前台展示章节信息")
public class ChapterDTO {

    private String id;
    private String title;

    private List<VideoDTO> children = new ArrayList<>();
}

package com.lijiawei.education.serviceedu.entity.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li JiaWei
 * @ClassName: SubjectNestedDTO
 * @Description: 课程一级分类信息
 * @Date: 2022/11/1 11:30
 * @Version: 1.0
 */
@Data
public class SubjectNestedDTO {

    private String id;
    private String title;
    private List<SubjectDTO> children = new ArrayList<>();
}

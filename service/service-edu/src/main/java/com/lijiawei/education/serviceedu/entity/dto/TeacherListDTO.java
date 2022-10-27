package com.lijiawei.education.serviceedu.entity.dto;

import com.lijiawei.education.serviceedu.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class TeacherListDTO {

    private List<Teacher> teacherList;
    private Integer totalCount;

    public TeacherListDTO(List<Teacher> teacherList) {
        this.teacherList = teacherList;
        this.totalCount = teacherList.size();
    }
}

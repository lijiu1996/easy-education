package com.lijiawei.education.serviceedu.entity.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author Li JiaWei
 * @ClassName: SubjectExcel
 * @Description:
 * @Date: 2022/10/27 15:17
 * @Version: 1.0
 */
@Data
public class SubjectExcel {

    @ExcelProperty(value = "一级名称",index = 0)
    private String firstName;
    @ExcelProperty(value = "二级名称",index = 1)
    private String secondName;
}

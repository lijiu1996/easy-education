package com.lijiawei.education.serviceedu.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.util.ListUtils;
import com.lijiawei.education.serviceedu.entity.bean.SubjectExcel;
import com.lijiawei.education.serviceedu.util.PathUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class EasyExcelTest {

    @Test
    public void writeExcel() {
        String path = PathUtil.getPath();
        System.out.println(path);
        String filename = "D:\\" + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(filename,DemoData.class)
                .sheet("demo1")
                .doWrite(() -> {
                    return data();
                });
    }

    @Test
    public void simpleRead() {
        String filename = "D:\\test.xlsx";
        EasyExcel.read(filename, SubjectExcel.class,new PageReadListener<SubjectExcel>(dataList -> {
            for (SubjectExcel subjectExcelData : dataList) {
                log.info("读取到一条数据{}",subjectExcelData.toString());
            }
        }))
                .sheet()
                .doRead();
    }

    private List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.5 + i);
            list.add(data);
        }
        return list;
    }
}

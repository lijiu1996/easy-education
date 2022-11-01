package com.lijiawei.education.serviceedu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.lijiawei.education.serviceedu.entity.bean.SubjectExcel;
import com.lijiawei.education.serviceedu.entity.po.Subject;
import com.lijiawei.education.serviceedu.mapper.SubjectMapper;
import com.lijiawei.education.serviceedu.service.ISubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-27
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements ISubjectService {

    @SneakyThrows
    @Override
    public boolean addSubjectTable(MultipartFile file) {
        Map<String,Subject> subjectMap = new HashMap<>();
        EasyExcel.read(file.getInputStream(), SubjectExcel.class, new PageReadListener<SubjectExcel>(dataList -> {
            for (SubjectExcel subjectExcel : dataList) {
                String firstName = subjectExcel.getFirstName();
                String secondName = subjectExcel.getSecondName();
                Subject subject = subjectMap.get(firstName);
                if (subject == null) {
                    subject = new Subject();
                    subject.setParentId("0");
                    subject.setTitle(firstName);
                    this.save(subject);
                    subjectMap.put(firstName,subject);
                }
                if (subjectMap.get(firstName + "-" + secondName) == null) {
                    Subject newSubject = new Subject();
                    newSubject.setParentId(subject.getId());
                    newSubject.setTitle(secondName);
                    this.save(newSubject);
                    subjectMap.put(firstName + "-" + secondName, newSubject);
                }
            }
        })).sheet().doRead();
        return true;
    }

    // 返回课程信息嵌套列表
    @Override
    public void getListByCourseId(String id) {

    }
}

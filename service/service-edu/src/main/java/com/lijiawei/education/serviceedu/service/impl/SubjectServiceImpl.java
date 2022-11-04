package com.lijiawei.education.serviceedu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.lijiawei.education.commonbase.union.exception.BusinessException;
import com.lijiawei.education.serviceedu.controller.SubjectController;
import com.lijiawei.education.serviceedu.entity.bean.SubjectExcel;
import com.lijiawei.education.serviceedu.entity.dto.SubjectDTO;
import com.lijiawei.education.serviceedu.entity.dto.SubjectNestedDTO;
import com.lijiawei.education.serviceedu.entity.po.Subject;
import com.lijiawei.education.serviceedu.mapper.SubjectMapper;
import com.lijiawei.education.serviceedu.service.ISubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    // 根据id返回课程分类信息以及二级分类
    @Override
    public void getListByCourseId(String id) {

    }

    // 返回所有课程信息以及嵌套的列表信息
    @Override
    public List<SubjectNestedDTO> getSubjects() {

//        List<SubjectNestedDTO> resultList = new ArrayList<>();
//
//        // 获取一级分类数据记录
//        List<Subject> list = this.list();
//
//        Map<String,SubjectNestedDTO> cache = new HashMap<>();
//
//        for (int i = 0; i < list.size(); i++) {
//            Subject subject = list.get(i);
//            if (subject.getParentId().equals("0")) {
//                // 属于一级分类
//                SubjectNestedDTO subjectNestedDTO = new SubjectNestedDTO();
//                BeanUtils.copyProperties(subject,subjectNestedDTO);
//                subjectNestedDTO.setChildren(new ArrayList<>());
//                cache.put(subject.getId(),subjectNestedDTO);
//                resultList.add(subjectNestedDTO);
//            } else {
//                // 属于二级分类
//                SubjectNestedDTO subjectNestedDTO = cache.get(subject.getParentId());
//                if (subjectNestedDTO == null)
//                    throw new BusinessException("未找到二级课程分类对应的一级分类信息",500);
//                SubjectDTO subjectDTO = new SubjectDTO();
//                BeanUtils.copyProperties(subject,subjectDTO);
//                subjectNestedDTO.getChildren().add(subjectDTO);
//            }
//        }
//        return resultList;
        return getSubjectsBySteam();
    }

    @Override
    public List<SubjectDTO> getSubjectList(String id) {
        LambdaQueryWrapper<Subject> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Subject::getParentId,id);
        return this.list(lqw).stream().
                map(subject -> {
                    SubjectDTO subjectDTO = new SubjectDTO();
                    BeanUtils.copyProperties(subject,subjectDTO);
                    return subjectDTO;
                }).collect(Collectors.toList());
    }

    public List<SubjectNestedDTO> getSubjectsBySteam() {
        List<Subject> list = this.list();
        Map<String, SubjectNestedDTO> cache = list.stream().
                filter(subject -> subject.getParentId().equals("0"))
                .map(subject -> {
                    SubjectNestedDTO subjectNestedDTO = new SubjectNestedDTO();
                    BeanUtils.copyProperties(subject, subjectNestedDTO);
                    return subjectNestedDTO;
                }).collect(Collectors.toMap(SubjectNestedDTO::getId, Function.identity()));
        list.stream()
                .filter(subject -> !subject.getParentId().equals("0"))
                .forEach(subject -> {
                    SubjectDTO subjectDTO = new SubjectDTO();
                    BeanUtils.copyProperties(subject,subjectDTO);
                    cache.get(subject.getParentId()).getChildren().add(subjectDTO);
                });
        return cache.values().stream().collect(Collectors.toList());
    }
}

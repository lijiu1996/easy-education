package com.lijiawei.education.serviceedu.service;

import com.lijiawei.education.serviceedu.entity.po.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-27
 */
public interface ISubjectService extends IService<Subject> {

    boolean addSubjectTable(MultipartFile file);
}

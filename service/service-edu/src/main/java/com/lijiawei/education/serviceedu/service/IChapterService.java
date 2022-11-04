package com.lijiawei.education.serviceedu.service;

import com.lijiawei.education.serviceedu.entity.dto.ChapterDTO;
import com.lijiawei.education.serviceedu.entity.po.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-31
 */
public interface IChapterService extends IService<Chapter> {

    List<ChapterDTO> nestedList(String id);
}

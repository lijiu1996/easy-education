package com.lijiawei.education.serviceedu.service;

import com.lijiawei.education.serviceedu.entity.po.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-31
 */
public interface IVideoService extends IService<Video> {

    boolean getCountByChapterId(String id);

    boolean deleteByChapterIdForce(String id);

    boolean deleteByCourseIdForce(String id);
}

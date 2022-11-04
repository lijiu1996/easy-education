package com.lijiawei.education.serviceedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lijiawei.education.serviceedu.entity.po.Video;
import com.lijiawei.education.serviceedu.mapper.VideoMapper;
import com.lijiawei.education.serviceedu.service.IVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-31
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {

    @Override
    public boolean getCountByChapterId(String id) {
        LambdaQueryWrapper<Video> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Video::getChapterId,id);
        long count = this.count(lqw);
        return count > 0;
    }

    @Override
    public boolean deleteByChapterIdForce(String id) {
        LambdaQueryWrapper<Video> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Video::getChapterId,id);
        return this.remove(lqw);
    }

    @Override
    public boolean deleteByCourseIdForce(String id) {
        LambdaQueryWrapper<Video> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Video::getCourseId,id);
        return this.remove(lqw);
    }
}

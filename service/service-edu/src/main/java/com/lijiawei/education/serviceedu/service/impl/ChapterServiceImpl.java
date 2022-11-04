package com.lijiawei.education.serviceedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.lijiawei.education.serviceedu.entity.dto.ChapterDTO;
import com.lijiawei.education.serviceedu.entity.dto.VideoDTO;
import com.lijiawei.education.serviceedu.entity.po.Chapter;
import com.lijiawei.education.serviceedu.entity.po.Video;
import com.lijiawei.education.serviceedu.mapper.ChapterMapper;
import com.lijiawei.education.serviceedu.service.IChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lijiawei.education.serviceedu.service.IVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-31
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements IChapterService {

    private final IVideoService videoService;

    public ChapterServiceImpl(IVideoService videoService) {
        this.videoService = videoService;
    }

    @Override
    public List<ChapterDTO> nestedList(String id) {

        // 最终要的到的数据列表
        List<ChapterDTO> chapterDTOList = new ArrayList<>();
        // 从数据库获取章节信息
        LambdaQueryWrapper<Chapter> qw = new LambdaQueryWrapper<>();
        qw.eq(Chapter::getCourseId,id);
        qw.orderByAsc(Chapter::getId);
        List<Chapter> chapterList = this.list(qw);

        // 获取课时信息
        LambdaQueryWrapper<Video> qw2 = new LambdaQueryWrapper<>();
        qw2.eq(Video::getCourseId,id);
        qw2.orderByAsc(Video::getId);
        List<Video> videoList = videoService.list(qw2);

        // 填充章节vo数据
        for (Chapter chapter : chapterList) {
            ChapterDTO chapterDTO = new ChapterDTO();
            BeanUtils.copyProperties(chapter,chapterDTO);
            chapterDTO.setChildren(new ArrayList<>());
            chapterDTOList.add(chapterDTO);

            for (Video video : videoList) {
                if (video.getChapterId().equals(chapter.getId())) {
                    VideoDTO videoDTO = new VideoDTO();
                    BeanUtils.copyProperties(videoDTO,video);
                    chapterDTO.getChildren().add(videoDTO);
                }
            }
        }


        return chapterDTOList;
    }


}

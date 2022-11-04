package com.lijiawei.education.serviceedu.controller;

import com.lijiawei.education.commonbase.union.result.UnionResponse;
import com.lijiawei.education.serviceedu.entity.po.Video;
import com.lijiawei.education.serviceedu.service.IVideoService;
import com.lijiawei.education.serviceedu.service.impl.VideoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-31
 */
@Api(tags = "小节管理")
@UnionResponse
@RestController
@RequestMapping("/service_edu/video")
@CrossOrigin
public class VideoController {

    private final IVideoService videoService;

    public VideoController(IVideoService videoService) {
        this.videoService = videoService;
    }

    //添加小节
    @PostMapping
    @ApiOperation("添加小节")
    public boolean addVideo(@RequestBody Video video) {
        videoService.save(video);
        return true;
    }

    //删除小节
    @DeleteMapping("{id}")
    @ApiOperation("删除小节")
    public boolean deleteVideo(@PathVariable String id) {
        videoService.removeById(id);
        return true;
    }
}

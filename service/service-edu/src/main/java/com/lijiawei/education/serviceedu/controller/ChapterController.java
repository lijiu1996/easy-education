package com.lijiawei.education.serviceedu.controller;

import com.lijiawei.education.commonbase.union.result.UnionResponse;
import com.lijiawei.education.serviceedu.entity.dto.ChapterDTO;
import com.lijiawei.education.serviceedu.entity.po.Chapter;
import com.lijiawei.education.serviceedu.service.IChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * edu 0.2.0 课程章节小节相关信息存储
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-31
 */
@Api(tags = "章节管理")
@UnionResponse
@RestController
@RequestMapping("/service_edu/chapter")
@CrossOrigin
public class ChapterController {

    private final IChapterService chapterService;

    public ChapterController(IChapterService chapterService) {
        this.chapterService = chapterService;
    }

    // 1. 根据课程id查询该课程对应的章节和小节信息（嵌套两层)
    @ApiOperation("返回课程对应的章节列表信息")
    @GetMapping("{id}")
    public List<ChapterDTO> getListById(@PathVariable String id) {
        return chapterService.nestedList(id);
    }

    @ApiOperation("添加课程的章节信息")
    @PostMapping()
    public void addChapterInfo() {

    }
}

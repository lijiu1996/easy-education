package com.lijiawei.education.serviceedu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 课程视频
 * </p>
 *
 * @author lijiawei
 * @since 2022-10-31
 */
@Getter
@Setter
@TableName("edu_video")
@ApiModel(value = "Video对象", description = "课程视频")
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("视频ID")
    private String id;

    @ApiModelProperty("课程ID")
    private String courseId;

    @ApiModelProperty("章节ID")
    private String chapterId;

    @ApiModelProperty("节点名称")
    private String title;

    @ApiModelProperty("云端视频资源")
    private String videoSourceId;

    @ApiModelProperty("原始文件名称")
    private String videoOriginalName;

    @ApiModelProperty("排序字段")
    private Integer sort;

    @ApiModelProperty("播放次数")
    private Long playCount;

    @ApiModelProperty("是否可以试听：0收费 1免费")
    private Integer isFree;

    @ApiModelProperty("视频时长（秒）")
    private Float duration;

    @ApiModelProperty("Empty未上传 Transcoding转码中  Normal正常")
    private String status;

    @ApiModelProperty("视频源文件大小（字节）")
    private Long size;

    @ApiModelProperty("乐观锁")
    private Long version;

    @ApiModelProperty("创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty("更新时间")
    private LocalDateTime gmtModified;


}

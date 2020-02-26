package cn.fanqie.homework.job.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 任务表：用户发布的任务表
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BJob implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 作业id
     */
    @TableId(value = "job_id", type = IdType.UUID)
    private String jobId;

    /**
     * 发布人
     */
    private String userId;

    /**
     * 作业标题
     */
    private String jobTitle;

    /**
     * 作业语音
     */
    private String jobVoice;

    /**
     * 作业文字
     */
    private String jobCharacter;

    /**
     * 提交方式
     */
//    private String jobSubmitType;

    /**
     * 提交人数
     */
//    private Integer jobPublishNo;

    /**
     * 发布时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date jobPublishDate;

    /**
     * 结束时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date jobEndDate;

    /**
     * 是否结束
     */
    private Boolean jobIfEnd;

    /**
     * 作业备注
     */
    private String jobRemark;

    /**
     * 删除否
     */
    private Integer deleteFlag;
}

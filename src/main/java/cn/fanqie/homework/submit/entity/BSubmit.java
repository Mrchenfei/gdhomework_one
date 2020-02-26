package cn.fanqie.homework.submit.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

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
 * 任务提交表：用户提交作业表
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BSubmit implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 作业提交id
     */
    @TableId(value = "submit_id", type = IdType.UUID)
    private String submitId;

    /**
     * 作业id
     */
    private String jobId;

    /**
     * 作业提交人id
     */
    private String userId;

    /**
     * 作业提交时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date submitDate;

    /**
     * 作业语音链接
     */
    private String submitVoice;

    /**
     * 作业文字内容
     */
    private String submitlCharacter;

    /**
     * 作业得分
     */
    private Integer submitScore;

    /**
     * 作业得分等级
     */
    private Integer submitScale;

    /**
     * 作业评分时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date submitMarkDate;

    /**
     * 作业提交评分语音
     */
    private String submitScoreVoice;

    /**
     * 作业提交评分内容
     */
    private String submitScoreCharacter;

    /**
     * 作业是否批改
     */
    private Integer submitModify;
    /**
     * 作业是否提交
     */
    private Integer submitIf;
    /**
     * 作业提交备注
     */
    private String submitRemark;

    /**
     * 班组id
     */
    private String teamId;

    /**
     * 作业是否查看
     */
    private Integer submitLookIf;
}

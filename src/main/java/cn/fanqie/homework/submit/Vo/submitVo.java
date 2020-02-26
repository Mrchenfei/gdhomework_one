package cn.fanqie.homework.submit.Vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class submitVo {
    /**
     * 作业提交id
     */
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
     * 用户昵称
     */
    private String userNickname;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userHeadportrait;

    /**
     * 作业提交时间
     */
    private LocalDateTime submitDate;

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
    private LocalDateTime submitMarkDate;

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
    private List<String> submitRemark;

    /**
     * 作业文字内容
     */
    private String submitlCharacter;

    /**
     * 作业语音链接
     */
    private String submitVoice;

    /**
     * 班组id
     */
    private String teamId;

    /**
     * 班组名称
     */
    private String teamName;

    /**
     * 作业标题
     */
    private String jobTitle;

    /**
     * 作业文字
     */
    private String jobCharacter;

    /**
     * 作业语音
     */
    private String jobVoice;

    /**
     * 提交方式
     */
    private String jobSubmitType;

    /**
     * 提交人数
     */
    private Integer jobPublishNo;

    /**
     * 发布时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date jobPublishDate;

    /**
     * 结束时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date jobEndDate;

    /**
     * 作业备注
     */
    private String jobRemark;

    /**
     * 是否结束
     */
    private Boolean jobIfEnd;

    /**
     * 删除否
     */
    private Integer deleteFlag;

    /**
     * 是否查看
     */
    private Integer lookIf;

    /**
     * 作业是否查看
     */
    private Integer submitLookIf;

    private List<String> jobImgId;
}

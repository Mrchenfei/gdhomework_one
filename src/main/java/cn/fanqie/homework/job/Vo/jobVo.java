package cn.fanqie.homework.job.Vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class jobVo {

    private static final long serialVersionUID=1L;

    /**
     * 作业id
     */
    private String jobId;

    /**
     * 发布人
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 用户头像
     */
    private String userHeadportrait;

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
     * 班组名称
     */
    private String teamName;

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

    private List<String> jobImgId;

    private List<String> jobTeamId;
}

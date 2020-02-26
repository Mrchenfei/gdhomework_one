package cn.fanqie.homework.team.Vo;

import com.alibaba.fastjson.annotation.JSONField;
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
public class teamVo {
    /**
     * 班组id
     */
    private String teamId;

    /**
     * 组建人id
     */
    private String userBuildId;

    /**
     * 班组员id
     */
    private String userLeaderId;

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
     * 班组名称
     */
    private String teamName;

    /**
     * 组建时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date teamBuilddate;

    /**
     * 班组类型
     */
    private Integer teamType;

    /**
     * 组建人数
     */
    private Integer teamNo;

    /**
     * 是否同校其余老师可见
     */
    private Integer teamIfVisible;

    /**
     * 是否同校其余老师可操作
     */
    private Integer teamIfOperation;

    /**
     * 班组备注
     */
    private String teamRemark;

    /**
     * 班组明细id
     */
    private String teamdetailId;

    /**
     * 班组员id
     */
    private String userCrewId;

    /**
     * 添加时间
     */
    private LocalDateTime teamdetailAddDate;

    /**
     * 班组明细备注
     */
    private String teamdetailRemark;

    private List<String> TeamUserId;
}

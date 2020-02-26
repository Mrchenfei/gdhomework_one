package cn.fanqie.homework.team.entity;

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
 * 班组表：将用户组建成以班或小组为单位
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BTeam implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 班组id
     */
    @TableId(value = "team_id", type = IdType.UUID)
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


}

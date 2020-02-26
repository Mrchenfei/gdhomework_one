package cn.fanqie.homework.job.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 任务班组表：作业发布的班组
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BJobTeam implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 作业发布班组id
     */
    @TableId(value = "job_team_id", type = IdType.UUID)
    private String jobTeamId;

    /**
     * 班组id
     */
    private String jobId;

    /**
     * 个人用户
     */
    private String userId;

    /**
     * 发布班组
     */
    private String teamId;


}

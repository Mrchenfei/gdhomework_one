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
 * 班组明细表：班组的成员记录
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BTeamdetail implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 班组明细id
     */
    @TableId(value = "teamdetail_id", type = IdType.UUID)
    private String teamdetailId;

    /**
     * 班组id
     */
    private String teamId;

    /**
     * 班组员id
     */
    private String userCrewId;

    /**
     * 添加时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date teamdetailAddDate;

    /**
     * 班组明细备注
     */
    private String teamdetailRemark;


}

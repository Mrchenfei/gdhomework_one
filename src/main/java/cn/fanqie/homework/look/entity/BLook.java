package cn.fanqie.homework.look.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 查看表：用户查看发布人的作业信息记录
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BLook implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 查看id
     */
    @TableId(value = "look_id", type = IdType.UUID)
    private String lookId;

    /**
     * 作业id
     */
    private String jobId;

    /**
     * 查看人id
     */
    private String userId;

    /**
     * 班组id
     */
    private String teamId;

    /**
     * 查看时间
     */
    private LocalDateTime lookDate;

    /**
     * 是否查看
     */
    private Integer lookIf;


}

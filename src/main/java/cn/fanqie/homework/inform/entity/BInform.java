package cn.fanqie.homework.inform.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 通知表：用于小程序助手通知用户
 * </p>
 *
 * @author liang
 * @since 2019-12-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BInform implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 通知id
     */
    @TableId(value = "inform_id", type = IdType.UUID)
    private String informId;

    /**
     * 通知发布人id
     */
    private String publishUuserId;

    /**
     * 通知发布对象
     */
    private String informUserId;

    /**
     * 通知标题
     */
    private String informTitle;

    /**
     * 通知内容
     */
    private String informContent;

    /**
     * 通知时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime informDate;

    /**
     * 公众号id
     */
    private String publicId;

    /**
     * 消息通知状态
     */
    private Boolean informState;

    /**
     * 消息通知路径
     */
    private String informPath;

    /**
     * 通知类型
     */
    private String informType;

    /**
     * 分组id
     */
    private String informTeamId;

    /**
     * 消息通知查看否
     */
    private Boolean informLookIf;
}

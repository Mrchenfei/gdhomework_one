package cn.fanqie.homework.inform.Vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class informVo {
    /**
     * 通知id
     */
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
     * 发布人名称
     */
    private String publishUserName;

    /**
     * 通知人名称
     */
    private String informUserName;

    /**
     * 班组名称
     */
    private String teamName;
}

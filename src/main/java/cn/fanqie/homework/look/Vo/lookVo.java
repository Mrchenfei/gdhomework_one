package cn.fanqie.homework.look.Vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class lookVo {

    /**
     * 查看id
     */
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
     * 班组id
     */
    private String teamId;

    /**
     * 查看时间
     */
    private Data lookDate;

    /**
     * 是否查看
     */
    private Integer lookIf;

    /**
     * 作业提交id
     */
    private String submitId;
}

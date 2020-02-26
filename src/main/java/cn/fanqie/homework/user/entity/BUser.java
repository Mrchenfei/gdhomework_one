package cn.fanqie.homework.user.entity;

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
 * 用户表：注册新用户
 * </p>
 *
 * @author liang
 * @since 2019-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.UUID)
    private String userId;

    /**
     * 微信id
     */
    private String wechatId;

    /**
     * 公众号id
     */
    private String publicId;

    /**
     * Unionid
     */
    private String UnionId;

    /**
     * 用户类型id
     */
    private String userTypeId;

    /**
     * 学校id
     */
    private String schoolId;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户性别
     */
    private Boolean userSex;

    /**
     * 用户头像
     */
    private String userHeadportrait;

    /**
     * 用户手机号码
     */
    private String userNumber;

    /**
     * 用户学校
     */
//    private String userSchool;

    /**
     * 用户年级
     */
    private String userGrade;

    /**
     * 用户班级
     */
//    private String userClass;

    /**
     * 用户注册日期
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date userRecorddate;

    /**
     * 用户科目
     */
    private String userSubject;

    /**
     * 用户备注
     */
    private String userRemark;

    /**
     * 用户删除否
     */
    private Integer deleteFlag;


}

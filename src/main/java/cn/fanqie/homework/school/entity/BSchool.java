package cn.fanqie.homework.school.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liang
 * @since 2020-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BSchool implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 学校ID
     */
    private String schoolId;

    /**
     * 学校名称
     */
    private String schoolName;

    /**
     * 学校地址
     */
    private String schoolSite;

    /**
     * 学校负责人
     */
    private String schoolPrincipal;

    /**
     * 联系电话
     */
    private String schoolPhone;

    /**
     * 学校简介
     */
    private String schoolBrief;


}

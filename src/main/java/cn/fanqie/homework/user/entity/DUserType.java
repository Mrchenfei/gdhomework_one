package cn.fanqie.homework.user.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户类型表：描述注册用户类型
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DUserType implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户类型id
     */
    private String userTypeId;

    /**
     * 用户类型名称
     */
    private String userTypeName;

    /**
     * 用户类型备注
     */
    private String userTypeRemark;


}

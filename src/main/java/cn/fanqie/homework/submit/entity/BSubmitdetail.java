package cn.fanqie.homework.submit.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 任务提交明细表：作业提交的明细信息
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BSubmitdetail implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 作业提交明细id
     */
    @TableId(value = "submitdetail_id", type = IdType.UUID)
    private String submitdetailId;

    /**
     * 作业提交id
     */
    private String submitId;

    /**
     * 图片链接
     */
    private String submitdetailSrc;


}

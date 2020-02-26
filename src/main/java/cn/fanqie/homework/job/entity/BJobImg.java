package cn.fanqie.homework.job.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 任务图片表：作业内容的多张图片
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BJobImg implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 作业发布图片id
     */
    @TableId(value = "job_img_id", type = IdType.UUID)
    private String jobImgId;

    /**
     * 作业id
     */
    private String jobId;

    /**
     * 图片链接
     */
    private String jobImgSrc;


}

package cn.fanqie.homework.job.service;

import cn.fanqie.homework.job.entity.BJobImg;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 任务图片表：作业内容的多张图片 服务类
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
public interface IBJobImgService extends IService<BJobImg> {
    List<BJobImg> selectJobImglist(String jobId);
}

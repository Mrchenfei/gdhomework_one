package cn.fanqie.homework.job.service;

import cn.fanqie.homework.job.Vo.jobVo;
import cn.fanqie.homework.job.entity.BJob;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 任务表：用户发布的任务表 服务类
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
public interface IBJobService extends IService<BJob> {
    List<BJob> selectJoblist(String userId);

    jobVo selectJobOne(String userId);

    List<jobVo> selectAllJobList();

    List<jobVo> selectAllAJobList();
}

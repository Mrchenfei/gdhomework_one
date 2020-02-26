package cn.fanqie.homework.job.service.impl;

import cn.fanqie.homework.job.Vo.jobVo;
import cn.fanqie.homework.job.entity.BJob;
import cn.fanqie.homework.job.mapper.BJobMapper;
import cn.fanqie.homework.job.service.IBJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 任务表：用户发布的任务表 服务实现类
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Service
public class BJobServiceImpl extends ServiceImpl<BJobMapper, BJob> implements IBJobService {
    @Autowired
    private BJobMapper bJobMapper;
    @Override
    public List<BJob> selectJoblist(String userId) {
        return bJobMapper.selectJoblist(userId);
    }

    @Override
    public jobVo selectJobOne(String userId) {
        return bJobMapper.selectJobOne(userId);
    }

    @Override
    public List<jobVo> selectAllJobList() {
        return bJobMapper.selectAllJobList();
    }

    @Override
    public List<jobVo> selectAllAJobList() {
        return bJobMapper.selectAllAJobList();
    }


}

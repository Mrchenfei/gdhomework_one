package cn.fanqie.homework.submit.service.impl;

import cn.fanqie.homework.submit.Vo.submitVo;
import cn.fanqie.homework.submit.entity.BSubmit;
import cn.fanqie.homework.submit.mapper.BSubmitMapper;
import cn.fanqie.homework.submit.service.IBSubmitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 任务提交表：用户提交作业表 服务实现类
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Service
public class BSubmitServiceImpl extends ServiceImpl<BSubmitMapper, BSubmit> implements IBSubmitService {
    @Autowired
    private BSubmitMapper submitMapper;
    @Override
    public List<submitVo> selectsubmitlist(String userId) {
        return submitMapper.selectsubmitlist(userId);
    }

    @Override
    public List<submitVo> selectUsersubmitlist(String jobId) {
        return submitMapper.selectUsersubmitlist(jobId);
    }

    @Override
    public List<submitVo> selectjobsubmitlist(String userId) {
        return submitMapper.selectjobsubmitlist(userId);
    }

    @Override
    public List<submitVo> selectsubmitcaselist(String jobId, boolean submiIf) {
        return submitMapper.selectsubmitcaselist(jobId,submiIf);
    }

    @Override
    public List<submitVo> selectUsersubmitNolist(String jobId) {
        return submitMapper.selectUsersubmitNolist(jobId);
    }

    @Override
    public List<submitVo> selectUsersubmitcorrectlist(String jobId) {
        return submitMapper.selectUsersubmitcorrectlist(jobId);
    }

    @Override
    public submitVo selectUsersubmitOnelist(String submitId) {
        return submitMapper.selectUsersubmitOnelist(submitId);
    }
}

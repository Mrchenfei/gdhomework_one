package cn.fanqie.homework.submit.service.impl;

import cn.fanqie.homework.submit.entity.BSubmitdetail;
import cn.fanqie.homework.submit.mapper.BSubmitdetailMapper;
import cn.fanqie.homework.submit.service.IBSubmitdetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 任务提交明细表：作业提交的明细信息 服务实现类
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Service
public class BSubmitdetailServiceImpl extends ServiceImpl<BSubmitdetailMapper, BSubmitdetail> implements IBSubmitdetailService {

    @Autowired
    private BSubmitdetailMapper bSubmitdetailMapper;
    @Override
    public List<BSubmitdetail> selectsubmitdetaillist(String submitId) {

        return bSubmitdetailMapper.selectsubmitdetaillist(submitId);

    }
}

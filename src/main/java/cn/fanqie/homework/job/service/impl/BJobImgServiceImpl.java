package cn.fanqie.homework.job.service.impl;

import cn.fanqie.homework.job.entity.BJobImg;
import cn.fanqie.homework.job.mapper.BJobImgMapper;
import cn.fanqie.homework.job.service.IBJobImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 任务图片表：作业内容的多张图片 服务实现类
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Service
public class BJobImgServiceImpl extends ServiceImpl<BJobImgMapper, BJobImg> implements IBJobImgService {

    @Autowired
    private BJobImgMapper bJobImgMapper;

    @Override
    public List<BJobImg> selectJobImglist(String jobId) {
        return bJobImgMapper.selectJobImglist(jobId);
    }
}

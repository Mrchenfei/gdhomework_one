package cn.fanqie.homework.look.service.impl;

import cn.fanqie.homework.look.Vo.lookVo;
import cn.fanqie.homework.look.entity.BLook;
import cn.fanqie.homework.look.mapper.BLookMapper;
import cn.fanqie.homework.look.service.IBLookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 查看表：用户查看发布人的作业信息记录 服务实现类
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Service
public class BLookServiceImpl extends ServiceImpl<BLookMapper, BLook> implements IBLookService {
    @Autowired
    private BLookMapper bLookMapper;
    @Override
    public List<BLook> selecttrueLooklist(String jobId) {
        return bLookMapper.selecttrueLooklist(jobId);
    }

    @Override
    public List<lookVo> selecttrLooklist(String jobId) {
        return bLookMapper.selecttrLooklist(jobId);
    }
}

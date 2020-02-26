package cn.fanqie.homework.inform.service.impl;

import cn.fanqie.homework.inform.Vo.informVo;
import cn.fanqie.homework.inform.entity.BInform;
import cn.fanqie.homework.inform.mapper.BInformMapper;
import cn.fanqie.homework.inform.service.IBInformService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 通知表：用于小程序助手通知用户 服务实现类
 * </p>
 *
 * @author liang
 * @since 2019-12-31
 */
@Service
public class BInformServiceImpl extends ServiceImpl<BInformMapper, BInform> implements IBInformService {

    @Autowired
    private BInformMapper bInformMapper;
    @Override
    public List<informVo> selectinfolist() {
        return bInformMapper.selectinfolist();
    }

    @Override
    public informVo selectinfoSysone(String userId) {
        return bInformMapper.selectinfoSysone(userId);
    }
}

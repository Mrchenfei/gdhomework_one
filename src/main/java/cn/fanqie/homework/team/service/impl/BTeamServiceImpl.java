package cn.fanqie.homework.team.service.impl;

import cn.fanqie.homework.team.Vo.teamVo;
import cn.fanqie.homework.team.entity.BTeam;
import cn.fanqie.homework.team.mapper.BTeamMapper;
import cn.fanqie.homework.team.service.IBTeamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 班组表：将用户组建成以班或小组为单位 服务实现类
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Service
public class BTeamServiceImpl extends ServiceImpl<BTeamMapper, BTeam> implements IBTeamService {
    @Autowired
    private BTeamMapper bTeamMapper;
    @Override
    public List<BTeam> selectteamlist(String storeStockId) {
        return bTeamMapper.selectteamlist(storeStockId);
    }

    @Override
    public Integer selectAll() {
        return bTeamMapper.selectAll();
    }

    @Override
    public List<teamVo> selectmessagelist(String userId) {
        return bTeamMapper.selectmessagelist(userId);
    }

    @Override
    public BTeam selectteamOne(String userId) {
        return bTeamMapper.selectteamOne(userId);
    }
}

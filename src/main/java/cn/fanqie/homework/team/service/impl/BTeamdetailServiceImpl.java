package cn.fanqie.homework.team.service.impl;

import cn.fanqie.homework.team.entity.BTeamdetail;
import cn.fanqie.homework.team.mapper.BTeamMapper;
import cn.fanqie.homework.team.mapper.BTeamdetailMapper;
import cn.fanqie.homework.team.service.IBTeamdetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 班组明细表：班组的成员记录 服务实现类
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Service
public class BTeamdetailServiceImpl extends ServiceImpl<BTeamdetailMapper, BTeamdetail> implements IBTeamdetailService {
    @Autowired
    private BTeamdetailMapper bTeamdetailMapper;
    @Override
    public List<BTeamdetail> selectteamdetaillist(String teamId) {
        return bTeamdetailMapper.selectteamdetaillist(teamId);
    }

    @Override
    public boolean removeteam(String teamId) {
        return bTeamdetailMapper.removeteam(teamId);
    }

    @Override
    public boolean removeById(String teamId) {
        return bTeamdetailMapper.removeById(teamId);
    }

    @Override
    public BTeamdetail selectTeamdetailOne(String teamId, String userId) {
        return bTeamdetailMapper.selectTeamdetailOne(teamId,userId);
    }
}

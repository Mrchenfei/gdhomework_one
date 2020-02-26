package cn.fanqie.homework.team.service;

import cn.fanqie.homework.team.Vo.teamVo;
import cn.fanqie.homework.team.entity.BTeam;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 班组表：将用户组建成以班或小组为单位 服务类
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
public interface IBTeamService extends IService<BTeam> {

    List<BTeam> selectteamlist(String storeStockId);

    Integer selectAll();

    List<teamVo> selectmessagelist(String userId);

    BTeam selectteamOne(String userId);
}

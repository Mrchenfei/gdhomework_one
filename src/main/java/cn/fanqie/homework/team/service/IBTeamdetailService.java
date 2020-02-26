package cn.fanqie.homework.team.service;

import cn.fanqie.homework.team.entity.BTeamdetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 班组明细表：班组的成员记录 服务类
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
public interface IBTeamdetailService extends IService<BTeamdetail> {
    List<BTeamdetail> selectteamdetaillist(String teamId);
    boolean removeteam(String teamId);
    boolean removeById(String teamId);
    BTeamdetail selectTeamdetailOne(String teamId,String userId);
}

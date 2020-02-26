package cn.fanqie.homework.team.mapper;

import cn.fanqie.homework.team.Vo.teamVo;
import cn.fanqie.homework.team.entity.BTeam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 班组表：将用户组建成以班或小组为单位 Mapper 接口
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Mapper
public interface BTeamMapper extends BaseMapper<BTeam> {

    List<BTeam> selectteamlist(String storeStockId);

    Integer selectAll();

    List<teamVo> selectmessagelist(String userId);

    BTeam selectteamOne(String userId);
}

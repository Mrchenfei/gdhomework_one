package cn.fanqie.homework.team.mapper;

import cn.fanqie.homework.team.entity.BTeamdetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**x
 * <p>
 * 班组明细表：班组的成员记录 Mapper 接口
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Mapper
public interface BTeamdetailMapper extends BaseMapper<BTeamdetail> {

    List<BTeamdetail> selectteamdetaillist(String teamId);
    boolean removeteam(String teamId);
    boolean removeById(String teamId);
    BTeamdetail selectTeamdetailOne(String teamId,String userId);
}

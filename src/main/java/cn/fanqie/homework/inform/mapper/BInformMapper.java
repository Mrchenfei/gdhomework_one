package cn.fanqie.homework.inform.mapper;

import cn.fanqie.homework.inform.Vo.informVo;
import cn.fanqie.homework.inform.entity.BInform;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 通知表：用于小程序助手通知用户 Mapper 接口
 * </p>
 *
 * @author liang
 * @since 2019-12-31
 */
@Mapper
public interface BInformMapper extends BaseMapper<BInform> {
    List<informVo> selectinfolist();

    informVo selectinfoSysone(String userId);
}

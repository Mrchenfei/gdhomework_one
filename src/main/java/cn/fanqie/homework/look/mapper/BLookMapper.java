package cn.fanqie.homework.look.mapper;

import cn.fanqie.homework.look.Vo.lookVo;
import cn.fanqie.homework.look.entity.BLook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 查看表：用户查看发布人的作业信息记录 Mapper 接口
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Mapper
public interface BLookMapper extends BaseMapper<BLook> {

    List<BLook> selecttrueLooklist(String jobId);

    List<lookVo> selecttrLooklist(String jobId);
}

package cn.fanqie.homework.job.mapper;

import cn.fanqie.homework.job.Vo.jobVo;
import cn.fanqie.homework.job.entity.BJob;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 任务表：用户发布的任务表 Mapper 接口
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Mapper
public interface BJobMapper extends BaseMapper<BJob> {

    List<BJob> selectJoblist(String userId);

    jobVo selectJobOne(String userId);

    List<jobVo> selectAllJobList();

    List<jobVo> selectAllAJobList();
}

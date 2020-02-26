package cn.fanqie.homework.submit.mapper;

import cn.fanqie.homework.submit.Vo.submitVo;
import cn.fanqie.homework.submit.entity.BSubmit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 任务提交表：用户提交作业表 Mapper 接口
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Mapper
public interface BSubmitMapper extends BaseMapper<BSubmit> {
    List<submitVo> selectsubmitlist(String userId);

    List<submitVo> selectUsersubmitlist(String jobId);

    List<submitVo>selectjobsubmitlist(String userId);

    //查询作业已提交人数
    List<submitVo>selectsubmitcaselist(String jobId,boolean submiIf);

    //查询作业发布总人数
    List<submitVo> selectUsersubmitNolist(String jobId);

    //查询作业已批改人数
    List<submitVo> selectUsersubmitcorrectlist(String jobId);

    submitVo selectUsersubmitOnelist(String submitId);
}

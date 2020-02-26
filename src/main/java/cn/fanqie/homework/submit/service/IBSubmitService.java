package cn.fanqie.homework.submit.service;

import cn.fanqie.homework.submit.Vo.submitVo;
import cn.fanqie.homework.submit.entity.BSubmit;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 任务提交表：用户提交作业表 服务类
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
public interface IBSubmitService extends IService<BSubmit> {
    List<submitVo> selectsubmitlist(String userId);

    List<submitVo> selectUsersubmitlist(String jobId);

    List<submitVo>selectjobsubmitlist(String userId);

    List<submitVo>selectsubmitcaselist(String jobId,boolean submiIf);

    List<submitVo> selectUsersubmitNolist(String jobId);

    //查询作业已批改人数
    List<submitVo> selectUsersubmitcorrectlist(String jobId);

    submitVo selectUsersubmitOnelist(String submitId);
}

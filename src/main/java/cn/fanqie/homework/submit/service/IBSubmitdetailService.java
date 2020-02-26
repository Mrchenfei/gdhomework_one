package cn.fanqie.homework.submit.service;

import cn.fanqie.homework.submit.entity.BSubmitdetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 任务提交明细表：作业提交的明细信息 服务类
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
public interface IBSubmitdetailService extends IService<BSubmitdetail> {

    List<BSubmitdetail> selectsubmitdetaillist(String submitId);
}

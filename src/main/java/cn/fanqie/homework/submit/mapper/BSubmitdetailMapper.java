package cn.fanqie.homework.submit.mapper;

import cn.fanqie.homework.submit.entity.BSubmitdetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 任务提交明细表：作业提交的明细信息 Mapper 接口
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Mapper
public interface BSubmitdetailMapper extends BaseMapper<BSubmitdetail> {

    List<BSubmitdetail> selectsubmitdetaillist(String submitId);

}

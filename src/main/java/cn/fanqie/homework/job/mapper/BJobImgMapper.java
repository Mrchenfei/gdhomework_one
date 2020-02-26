package cn.fanqie.homework.job.mapper;

import cn.fanqie.homework.job.entity.BJobImg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 任务图片表：作业内容的多张图片 Mapper 接口
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Mapper
public interface BJobImgMapper extends BaseMapper<BJobImg> {
    List<BJobImg> selectJobImglist(String jobId);

}

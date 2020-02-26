package cn.fanqie.homework.look.service;

import cn.fanqie.homework.look.Vo.lookVo;
import cn.fanqie.homework.look.entity.BLook;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 查看表：用户查看发布人的作业信息记录 服务类
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
public interface IBLookService extends IService<BLook> {
    List<BLook> selecttrueLooklist(String jobId);
    List<lookVo> selecttrLooklist(String jobId);
}

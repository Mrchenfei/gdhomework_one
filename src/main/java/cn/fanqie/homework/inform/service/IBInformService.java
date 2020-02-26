package cn.fanqie.homework.inform.service;

import cn.fanqie.homework.inform.Vo.informVo;
import cn.fanqie.homework.inform.entity.BInform;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 通知表：用于小程序助手通知用户 服务类
 * </p>
 *
 * @author liang
 * @since 2019-12-31
 */
public interface IBInformService extends IService<BInform> {
    List<informVo> selectinfolist();
    informVo selectinfoSysone(String userId);
}

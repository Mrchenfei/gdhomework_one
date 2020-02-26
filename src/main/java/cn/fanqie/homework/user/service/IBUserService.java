package cn.fanqie.homework.user.service;

import cn.fanqie.homework.user.entity.BUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表：注册新用户 服务类
 * </p>
 *
 * @author liang
 * @since 2019-12-27
 */
public interface IBUserService extends IService<BUser> {

    BUser selectUserBywechatId(String openid);

}

package cn.fanqie.homework.user.service.impl;

import cn.fanqie.homework.user.entity.BUser;
import cn.fanqie.homework.user.mapper.BUserMapper;
import cn.fanqie.homework.user.service.IBUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表：注册新用户 服务实现类
 * </p>
 *
 * @author liang
 * @since 2019-12-27
 */
@Service
public class BUserServiceImpl extends ServiceImpl<BUserMapper, BUser> implements IBUserService {
    @Autowired
    private BUserMapper bUserMapper;

    @Override
    public BUser selectUserBywechatId(String openid) {
        return bUserMapper.selectUserBywechatId(openid);
    }
}

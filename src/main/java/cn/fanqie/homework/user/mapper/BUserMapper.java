package cn.fanqie.homework.user.mapper;

import cn.fanqie.homework.user.entity.BUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表：注册新用户 Mapper 接口
 * </p>
 *
 * @author liang
 * @since 2019-12-27
 */

@Mapper
public interface BUserMapper extends BaseMapper<BUser> {

    BUser selectUserBywechatId(@Param("openid") String openid);
}

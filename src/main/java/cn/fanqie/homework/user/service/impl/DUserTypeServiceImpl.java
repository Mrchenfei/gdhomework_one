package cn.fanqie.homework.user.service.impl;

import cn.fanqie.homework.user.entity.DUserType;
import cn.fanqie.homework.user.mapper.DUserTypeMapper;
import cn.fanqie.homework.user.service.IDUserTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户类型表：描述注册用户类型 服务实现类
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@Service
public class DUserTypeServiceImpl extends ServiceImpl<DUserTypeMapper, DUserType> implements IDUserTypeService {

}

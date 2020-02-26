package cn.fanqie.homework.school.service.impl;

import cn.fanqie.homework.school.entity.BSchool;
import cn.fanqie.homework.school.mapper.BSchoolMapper;
import cn.fanqie.homework.school.service.IBSchoolService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liang
 * @since 2020-02-19
 */
@Service
public class BSchoolServiceImpl extends ServiceImpl<BSchoolMapper, BSchool> implements IBSchoolService {

    @Autowired
    private BSchoolMapper bSchoolMapper;

    @Override
    public List<BSchool> selectschoollist() {
        return bSchoolMapper.selectschoollist();
    }
}

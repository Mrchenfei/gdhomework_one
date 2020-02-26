package cn.fanqie.homework.school.service;

import cn.fanqie.homework.school.entity.BSchool;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liang
 * @since 2020-02-19
 */
public interface IBSchoolService extends IService<BSchool> {

    List<BSchool> selectschoollist();

}

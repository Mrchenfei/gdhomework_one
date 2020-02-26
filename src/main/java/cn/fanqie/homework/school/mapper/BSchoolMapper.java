package cn.fanqie.homework.school.mapper;

import cn.fanqie.homework.school.entity.BSchool;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liang
 * @since 2020-02-19
 */
@Mapper
public interface BSchoolMapper extends BaseMapper<BSchool> {

    List<BSchool> selectschoollist();

}

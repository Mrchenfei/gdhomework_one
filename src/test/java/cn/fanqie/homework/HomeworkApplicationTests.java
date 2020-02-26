package cn.fanqie.homework;

import cn.fanqie.homework.school.entity.BSchool;
import cn.fanqie.homework.school.service.IBSchoolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HomeworkApplicationTests {

    @Autowired
    private IBSchoolService ibSchoolService;

    @Test
    void contextLoads() {
    }

    @Test
    public List<BSchool> selectschoollist() {
        List<BSchool> pageList = ibSchoolService.selectschoollist();
        System.out.println(pageList);
        return pageList;
    }
}

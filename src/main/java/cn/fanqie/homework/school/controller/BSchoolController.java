package cn.fanqie.homework.school.controller;


import cn.fanqie.homework.school.entity.BSchool;
import cn.fanqie.homework.school.service.IBSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cn.fanqie.homework.core.BaseController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liang
 * @since 2020-02-19
 */
@RestController
@RequestMapping("/school/b-school")
public class BSchoolController extends BaseController {
    @Autowired
    private IBSchoolService ibSchoolService;
    /**
     * 身份登记页面选择学校
     */
    @GetMapping(value = "/selectschoollist")
    @ResponseBody
    public List<BSchool> selectschoollist() {
        List<BSchool> pageList = ibSchoolService.selectschoollist();
        return pageList;
    }

}


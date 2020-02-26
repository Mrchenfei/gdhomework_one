package cn.fanqie.homework.inform.controller;


import cn.fanqie.homework.inform.Vo.informVo;
import cn.fanqie.homework.inform.service.IBInformService;
import cn.fanqie.homework.school.entity.BSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cn.fanqie.homework.core.BaseController;

import java.util.List;

/**
 * <p>
 * 通知表：用于小程序助手通知用户 前端控制器
 * </p>
 *
 * @author liang
 * @since 2019-12-31
 */
@RestController
@RequestMapping("/inform/b-inform")
public class BInformController extends BaseController {

    @Autowired
    private IBInformService ibInformService;

    /**
     * 首页顶部查询所有的消息不包括公众号
     */
    @GetMapping(value = "/selectinfolist")
    @ResponseBody
    public List<informVo> selectinfolist() {
        List<informVo> pageList = ibInformService.selectinfolist();
        return pageList;
    }

    /**
     * 首页查询系统最新消息
     */
    @GetMapping(value = "/selectinfoone")
    @ResponseBody
    public informVo selectinfoone(String userId) {
        informVo pageList = ibInformService.selectinfoSysone(userId);
        return pageList;
    }

}


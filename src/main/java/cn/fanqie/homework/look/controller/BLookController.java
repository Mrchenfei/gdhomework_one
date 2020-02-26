package cn.fanqie.homework.look.controller;


import cn.fanqie.homework.look.Vo.lookVo;
import cn.fanqie.homework.look.entity.BLook;
import cn.fanqie.homework.look.service.IBLookService;
import cn.fanqie.homework.submit.Vo.submitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cn.fanqie.homework.core.BaseController;

import java.util.List;

/**
 * <p>
 * 查看表：用户查看发布人的作业信息记录 前端控制器
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/look/b-look")
public class BLookController extends BaseController {

    @Autowired
    private IBLookService ibLookService;

    /**
     *作业发布后查看的详情的情况数目
     */
    @GetMapping(value = "/selectlooketruelist")
    @ResponseBody
    public List<BLook> selectlooketruelist(String jobId) {
        //System.out.println("传进来的作业ID：" + jobId);
        //Result<List<StoreStockListVO>> result = new Result<>();
        List<BLook> pageList = ibLookService.selecttrueLooklist(jobId);
        //Integer integer = ibTeamService.selectAll();
        //System.out.println(pageList);
        return pageList;
    }

    /**
     *作业发布后查看详情的情况
     */
    @GetMapping(value = "/selecttrLooklist")
    @ResponseBody
    public List<lookVo> selecttrLooklist(String jobId) {
        System.out.println("传进来的作业ID：" + jobId);
        //Result<List<StoreStockListVO>> result = new Result<>();
        List<lookVo> pageList = ibLookService.selecttrLooklist(jobId);
        //Integer integer = ibTeamService.selectAll();
        System.out.println(pageList);
        return pageList;
    }
}


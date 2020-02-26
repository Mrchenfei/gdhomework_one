package cn.fanqie.homework.submit.controller;


import cn.fanqie.homework.submit.Vo.submitVo;
import cn.fanqie.homework.submit.entity.BSubmitdetail;
import cn.fanqie.homework.submit.service.IBSubmitdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cn.fanqie.homework.core.BaseController;

import java.util.List;

/**
 * <p>
 * 任务提交明细表：作业提交的明细信息 前端控制器
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/submit/b-submitdetail")
public class BSubmitdetailController extends BaseController {
    @Autowired
    private IBSubmitdetailService ibSubmitdetailService;
    /**
     *广场查看作业
     */
    @GetMapping(value = "/selectsubmitdetaillist")
    @ResponseBody
    public List<BSubmitdetail> selectsubmitdetaillist(String submitId) {
        System.out.println("--------------任务提交明细表：作业提交的明细信息 前端控制器----------------");
        //System.out.println(userId);
        //Result<List<StoreStockListVO>> result = new Result<>();
        List<BSubmitdetail> pageList = ibSubmitdetailService.selectsubmitdetaillist(submitId);
        //Integer integer = ibTeamService.selectAll();
        System.out.println(pageList);
        return pageList;
    }

}


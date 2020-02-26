package cn.fanqie.homework.job.controller;


import cn.fanqie.homework.job.entity.BJobImg;
import cn.fanqie.homework.job.service.IBJobImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cn.fanqie.homework.core.BaseController;

import java.util.List;

/**
 * <p>
 * 任务图片表：作业内容的多张图片 前端控制器
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/job/b-job-img")
public class BJobImgController extends BaseController {
    @Autowired
    private IBJobImgService ibJobImgService;

    /**
     *查看作业
     */
    @GetMapping(value = "/selectJobImglist")
    @ResponseBody
    public List<BJobImg> selectJobImglist(String jobId) {
        //System.out.println(userId);
        //Result<List<StoreStockListVO>> result = new Result<>();
        List<BJobImg> pageList = ibJobImgService.selectJobImglist(jobId);
        //Integer integer = ibTeamService.selectAll();
        System.out.println(pageList);
        return pageList;
    }
}


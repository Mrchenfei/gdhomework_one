package cn.fanqie.homework.team.controller;


import cn.fanqie.homework.team.entity.BTeam;
import cn.fanqie.homework.team.entity.BTeamdetail;
import cn.fanqie.homework.team.service.IBTeamService;
import cn.fanqie.homework.team.service.IBTeamdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cn.fanqie.homework.core.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 * 班组明细表：班组的成员记录 前端控制器
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/team/b-teamdetail")
public class BTeamdetailController extends BaseController {
    @Autowired
    private IBTeamService ibTeamService;
    @Autowired
    private IBTeamdetailService ibTeamdetailService;
    /**
     * 删除通讯录
     * @return
     */
    @GetMapping(value = "/delmessById")
    @ResponseBody
    public boolean delmessById(String teamId) {
        //boolean z = false;
        //boolean o = false;
        System.out.println("--------------删除通讯录----------------");
        System.out.println(teamId);
        boolean o = ibTeamdetailService.removeById(teamId);
        System.out.println(o);
        return o;
    }

    /**
     * 扫码互加
     * @param request
     * @return
     */
    @GetMapping("/UserecodeInsert")
    @ResponseBody
    public String UsercodeInsert(HttpServletRequest request){
        String myUserId = request.getParameter("myUserId");
        String youUserId = request.getParameter("youUserId");
        String z = "false";
        BTeam bTeam = ibTeamService.selectteamOne(youUserId);
        System.out.println(bTeam);
        if (bTeam !=null){
            System.out.println("班组表有该用户通讯录");
            System.out.println(bTeam.getTeamId());
            if(myUserId.equals(youUserId)){
                System.out.println("无法添加该联系人！无法添加自己！");
                z = "InsertOwn";
            }else{
                BTeamdetail bTeamdetail = ibTeamdetailService.selectTeamdetailOne(bTeam.getTeamId(),myUserId);
                if(bTeamdetail !=null){
                    System.out.println("通讯录已有该用户！不能重复添加！");
                    z = "InsertRepetition";
                }else{
                    BTeamdetail Sava = new BTeamdetail();
                    Sava.setTeamId(bTeam.getTeamId());
                    Sava.setUserCrewId(myUserId);
                    Sava.setTeamdetailAddDate(new Date());
                    boolean i = ibTeamdetailService.save(Sava);
                    if(i){
                        z = "succeed";
                    }
                }
            }
        }else {
            // 通讯录表没有通讯录0
            System.out.println("无法添加该联系人！请联系客服人员");
        }
        System.out.println(myUserId);
        System.out.println(youUserId);
        System.out.println(z);
        return z;
    }


}


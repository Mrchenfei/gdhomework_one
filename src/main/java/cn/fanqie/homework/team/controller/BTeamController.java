package cn.fanqie.homework.team.controller;


import cn.fanqie.homework.team.Vo.teamVo;
import cn.fanqie.homework.team.entity.BTeam;
import cn.fanqie.homework.team.entity.BTeamdetail;
import cn.fanqie.homework.team.service.IBTeamService;
import cn.fanqie.homework.team.service.IBTeamdetailService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.fanqie.homework.core.BaseController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 班组表：将用户组建成以班或小组为单位 前端控制器
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/team/b-team")
public class BTeamController extends BaseController {

    @Autowired
    private IBTeamService ibTeamService;
    @Autowired
    private IBTeamdetailService ibTeamdetailService;
    /**
     * 列表查询班组
     * @return
     */
    @GetMapping(value = "/selectteamlist")
    @ResponseBody
    public List<BTeam> selectStoreStockistDetailslist(String userId) {
        System.out.println(userId);
        //Result<List<StoreStockListVO>> result = new Result<>();
        List<BTeam> pageList = ibTeamService.selectteamlist(userId);
        //Integer integer = ibTeamService.selectAll();
        System.out.println(pageList);
        return pageList;
    }

    /**
     * 列表查询通讯录
     * @return
     */
    @GetMapping(value = "/selectmessagelist")
    @ResponseBody
    public List<teamVo> selectmessagelist(String userId) {
        System.out.println(userId);
        //Result<List<StoreStockListVO>> result = new Result<>();
        List<teamVo> pageList = ibTeamService.selectmessagelist(userId);
        //Integer integer = ibTeamService.selectAll();
        System.out.println(pageList);
        return pageList;
    }

    /**
     * 删除班组
     * @return
     */
    @GetMapping(value = "/delteamById")
    @ResponseBody
    public boolean delteamById(String teamId) {
        //boolean z = false;
        boolean i = false;
        System.out.println("--------------删除分组----------------");
        System.out.println(teamId);
        try {
            boolean o = ibTeamService.removeById(teamId);
            if(o){
                i = ibTeamdetailService.removeteam(teamId);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }

    @PostMapping("/teamUpdataName")
    @ResponseBody
    public Boolean teamUpdataName(BTeam bTeam){
        System.out.println(bTeam.getTeamId());
        System.out.println(bTeam.getTeamName());
//        String userId = request.getParameter("userId");
//        String userName = request.getParameter("userName");
//        String userSchool = request.getParameter("userSchool");
//        String userGrade = request.getParameter("userGrade");
        UpdateWrapper<BTeam> storeStockUpdateWrapper = new UpdateWrapper<>();
        storeStockUpdateWrapper.eq("team_id",bTeam.getTeamId());
        BTeam bUser = new BTeam();
        bUser.setTeamName(bTeam.getTeamName());
        Boolean ok = ibTeamService.update(bUser,storeStockUpdateWrapper);
        return ok;
    }

    @PostMapping("/teamInsert")
    @ResponseBody
    public Boolean teamInsert(teamVo bTeam){
        System.out.println("---------------------------新增分组-------------------------");
        System.out.println(bTeam);
        System.out.println(bTeam.getTeamName());
        BTeam bUser = new BTeam();
        bUser.setTeamName(bTeam.getTeamName());
        bUser.setUserBuildId(bTeam.getUserId());
        bUser.setTeamBuilddate(new Date());
        bUser.setTeamType(1);
        boolean q = ibTeamService.save(bUser);
        System.out.println(bUser.getTeamId());
        List<String> TeamNo = bTeam.getTeamUserId();
        if(TeamNo.size() != 0) {
            for (String teamId : TeamNo) {
                BTeamdetail bTeamdetail = new  BTeamdetail();
                bTeamdetail.setTeamId(bUser.getTeamId());
                bTeamdetail.setTeamdetailAddDate(new Date());
                bTeamdetail.setUserCrewId(teamId);
                boolean w = ibTeamdetailService.save(bTeamdetail);
                System.out.println("新增通讯明细Id："+w);
            }
            System.out.println();
        }
        Boolean ok = true;
        return ok;
    }
}


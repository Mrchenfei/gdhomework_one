package cn.fanqie.homework.user.controller;

import cn.fanqie.homework.config.AesCbcUtil;
import cn.fanqie.homework.config.HttpRequest;
import cn.fanqie.homework.config.Tools;
import cn.fanqie.homework.config.WechatInterface;
import cn.fanqie.homework.team.entity.BTeam;
import cn.fanqie.homework.team.service.IBTeamService;
import cn.fanqie.homework.user.entity.BUser;
import cn.fanqie.homework.user.service.IBUserService;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.fanqie.homework.core.BaseController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * <p>
 * 用户表：注册新用户 前端控制器
 * </p>
 *
 * @author liang
 * @since 2019-12-27
 */
@RestController
@RequestMapping("/user/b-user")
public class BUserController extends BaseController {

    @Autowired
    private IBUserService ibUserService;

    @Autowired
    private IBTeamService ibTeamService;

    @GetMapping("/UserSelect")
    @ResponseBody
    public BUser UserSelect(String openid){
        BUser list = ibUserService.selectUserBywechatId(openid);
        // 获取时间
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Date date=new Date();
        //String d=sdf.format(date);
        //bUser.setUserAccount(Timestamp.valueOf(date));
        // 随机数
        //long sws = (long) (Math.random()*10000000000L);
        //System.out.println(sws);
        return list;
    }

    @PostMapping("/UserInsert")
    @ResponseBody
    public String UserInsert(@RequestBody BUser bUser){
        long sws = (long) (Math.random()*10000000000L);
        bUser.setUserRecorddate(new Date());
        bUser.setDeleteFlag(0);
        bUser.setUserAccount(String.valueOf(sws));
        boolean insert = ibUserService.save(bUser);
        BTeam bTeam = new BTeam();
        bTeam.setUserBuildId(bUser.getUserId());
        bTeam.setTeamName("通讯录");
        bTeam.setTeamBuilddate(new Date());
        bTeam.setTeamType(0);
        bTeam.setTeamIfOperation(0);
        bTeam.setTeamIfVisible(0);
        boolean Team = ibTeamService.save(bTeam);
        String i = bUser.getUserId();
        return i;
    }

    @PostMapping("/UserUpdata")
    @ResponseBody
    public Boolean UserUpdata(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String userName = request.getParameter("userName");
        String userSchool = request.getParameter("userSchool");
        String userGrade = request.getParameter("userGrade");
        UpdateWrapper<BUser> storeStockUpdateWrapper = new UpdateWrapper<>();
        storeStockUpdateWrapper.eq("user_id",userId);
        BUser bUser = new BUser();
        bUser.setUserName(userName);
        //bUser.setUserSchool(userSchool);
        bUser.setUserGrade(userGrade);
        Boolean ok = ibUserService.update(bUser,storeStockUpdateWrapper);
        return ok;
    }

    /**
     * 获取微信用户appid与secret
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/loginUserData")
    @ResponseBody
    public Object loginUserData(HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {
        System.out.println("----------------------登录获取openid---------------------");
        try {
            // 获取参数
            String code = request.getParameter("code");// 获取登录时的code
            //吴总
            //String appid = "wx3a84f44cc00e2b1e";// 小程序唯一标识
            //String secret = "8eac041840c4510560227b013e10b6b6";// 小程序的 app
            //小梁
            String appid = "wx91195f89744167be";// 小程序唯一标识
            String secret = "33ec14e6ee6a1c0eba37bf2b7e8c2cb3";// 小程序的 app
            if (!Tools.isNotNull(code)) {
                return null;
            }
            String json = WechatInterface.getopenid(appid, code, secret);
            return json;

        } catch (Exception e) {
            return "404";
        }
    }










    /**
     * decoding encrypted data to get openid
     *
     * @param iv
     * @param encryptedData
     * @param code
     * @return
     */
//    @RequestMapping(value = "/decodeUserInfo", method = RequestMethod.GET)
//    private Map decodeUserInfo(String encryptedData, String iv, String code) {
//        System.out.println(encryptedData);
//        System.out.println(iv);
//        System.out.println(code);
//        System.out.println("--------------------oppid获取：------------------------");
//        Map map = new HashMap();
//        // login code can not be null
//        if (code == null || code.length() == 0) {
//            map.put("status", 0);
//            map.put("msg", "code 不能为空");
//            return map;
//        }
//        // mini-Program's AppID
//        String wechatAppId = "wx91195f89744167be";
//
//        // mini-Program's session-key
//        String wechatSecretKey = "6e28f0e37b4943c046869df9d369af7d";
//
//        String grantType = "authorization_code";
//
//        // using login code to get sessionId and openId
//        String params = "appid=" + wechatAppId + "&secret=" + wechatSecretKey + "&js_code=" + code + "&grant_type=" + grantType;
//
//        // sending request
//        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
//        System.out.println("Sr：" +sr);
//        // analysis request content
//        JSONObject json = JSONObject.fromObject(sr);
//        System.out.println("Sr：" +json);
//        // getting session_key
//        String sessionKey = json.get("session_key").toString();
//
//        // getting open_id
//        String openId = json.get("openid").toString();
//
//        // decoding encrypted info with AES
//        try {
//            String result = AesCbcUtil.decrypt(encryptedData, sessionKey, iv, "UTF-8");
//            if (null != result && result.length() > 0) {
//                map.put("status", 1);
//                map.put("msg", "解密成功");
//                //获取返回json结果集
//                JSONObject.fromObject(result);
//                System.out.println(JSONObject.fromObject(result));
//
//               com.alibaba.fastjson.JSONObject user =  JSON.parseObject(String.valueOf(JSONObject.fromObject(result)));
//               Map<String, Object> maps = new LinkedHashMap<String, Object>();
//                maps.put("openId",  user.getString("openId"));
//                maps.put("nickName", user.getString("nickName"));
//                maps.put("gender", user.getString("gender"));
//                maps.put("city", user.getString("city"));
//                maps.put("province", user.getString("province"));
//                maps.put("country", user.getString("country"));
//                maps.put("avatarUrl", user.getString("avatarUrl"));
////                userInfoJSON = JSONObject.fromObject(result);
// //              JSONObjectMap userInfo = new HashMap();
////                userInfo.put("openId", userInfoJSON.get("openId"));
////                userInfo.put("nickName", userInfoJSON.get("nickName"));
////                userInfo.put("gender", userInfoJSON.get("gender"));
////                userInfo.put("city", userInfoJSON.get("city"));
////                userInfo.put("province", userInfoJSON.get("province"));
////                userInfo.put("country", userInfoJSON.get("country"));
////                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
////                userInfo.put("unionId", userInfoJSON.get("unionId"));
//                  map.put("userInfo", maps);
//                System.out.println("--------------------oppid获取：------------------------");
//                System.out.println(map);
//                return map;
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        map.put("status", 0);
//        map.put("msg", "解密失败");
//        return map;
//    }

    /*@GetMapping("/UserSelect")
    @ResponseBody
    public BUser UserSelect(String openid){
        BUser list = ibUserService.selectUserBywechatId(openid);

        *//*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        System.out.println(formatter.format(calendar.getTime()));*//*

        Date date = new Date("yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
        System.out.println(list);
        return list;
    }

    @PostMapping("/UserInsert")
    @ResponseBody
    public String UserInsert(@RequestBody BUser bUser){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        BUser buser = new BUser();
        buser.setUserNickname(bUser.getUserNickname());
        buser.setUserSex(bUser.getUserSex());
        buser.setUserHeadportrait(bUser.getUserHeadportrait());
        buser.setWechatId(bUser.getWechatId());
        buser.setUserTypeId(bUser.getUserTypeId());
        Date date = new Date("yyyy-MM-dd HH:mm:ss");
        buser.setUserRecorddate(date);
        //获取注册日期

        boolean insert = ibUserService.save(bUser);
        String i = bUser.getUserId();
        return i;
    }*/
}


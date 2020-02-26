package cn.fanqie.homework.job.controller;


import cn.fanqie.homework.job.Vo.jobVo;
import cn.fanqie.homework.job.entity.BJob;
import cn.fanqie.homework.job.entity.BJobImg;
import cn.fanqie.homework.job.entity.BJobTeam;
import cn.fanqie.homework.job.service.IBJobImgService;
import cn.fanqie.homework.job.service.IBJobService;
import cn.fanqie.homework.job.service.IBJobTeamService;
import cn.fanqie.homework.look.entity.BLook;
import cn.fanqie.homework.look.service.IBLookService;
import cn.fanqie.homework.submit.entity.BSubmit;
import cn.fanqie.homework.submit.service.IBSubmitService;
import cn.fanqie.homework.team.Vo.teamVo;
import cn.fanqie.homework.team.entity.BTeamdetail;
import cn.fanqie.homework.team.service.IBTeamdetailService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.fanqie.homework.core.BaseController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 任务表：用户发布的任务表 前端控制器
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/job/b-job" )
public class BJobController extends BaseController {

    @Autowired
    private IBJobService ibJobService;
    @Autowired
    private IBJobImgService iBJobImgService;
    @Autowired
    private IBJobTeamService ibJobTeamService;
    @Autowired
    private IBLookService ibLookService;
    @Autowired
    private IBTeamdetailService ibTeamdetailService;
    @Autowired
    private IBSubmitService ibSubmitService;
    //文件上传
    @RequestMapping("/file_upload")
    public String saveFile(HttpServletRequest request) throws Exception {
        System.out.println("---------------------文件上传------------------------" );
        // 1.获取从前台传过来得图片
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = req.getFile("file");
        //System.out.println("文件大小：" + multipartFile.getSize());
        //System.out.println("文件名称：" + multipartFile.getOriginalFilename());
        // 2.获得文件扩展名
        String extOfFile = getExtOfFile(multipartFile);
        // 3.保存到本地
        BufferedOutputStream bos = null;
        String filename = null;
        try {
            File dir = new File("/mnt/jobItem/file/");
            if (!dir.exists()) {// 判断文件目录是否存在
                dir.mkdirs();
            }
            filename = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + (int) (Math.random() * 1000) + "."
                    + extOfFile;
            bos = new BufferedOutputStream(new FileOutputStream("/mnt/jobItem/file/" + filename));
            bos.write(multipartFile.getBytes());
            return  "https://homework.xuechenedu.com/img/file/" + filename;
        } catch (Exception e) {
            e.printStackTrace();
            String path = "上传失败！";
            return  path;
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //获取后缀名
    public String getExtOfFile(MultipartFile multipartFile) {
        // 获取文件的 名称.扩展名
        String oldName = multipartFile.getOriginalFilename();
        String extensionName = "";
        // 获取原来的扩展名
        if ((oldName != null) && (oldName.length() > 0)) {
            int dot = oldName.lastIndexOf('.');
            if ((dot > -1) && (dot < (oldName.length() - 1))) {
                extensionName = oldName.substring(dot+1);
            }
        }
        return extensionName;
    }

    /**
     * 查询作业
     */
    @GetMapping(value = "/selectJobOne")
    @ResponseBody
    public jobVo selectJobOne(String userId) {
        System.out.println("进来了");
        System.out.println(userId);
        jobVo user = this.ibJobService.selectJobOne(userId);
        System.out.println(user);
        return user;
    }

    /**
     * 新建作业发布
     * @param bJobV0
     * @return
     */
    @PostMapping("/jobInsert")
    @ResponseBody
    public String jobInsert(@RequestBody jobVo bJobV0){
        List<BJobImg> JobImg = new ArrayList<>();
        BJob bJob = new BJob();
        bJob.setUserId(bJobV0.getUserId());
        bJob.setJobTitle(bJobV0.getJobTitle());
        bJob.setJobCharacter(bJobV0.getJobCharacter());
        bJob.setJobVoice(bJobV0.getJobVoice());
        bJob.setJobPublishDate(new Date());
        bJob.setJobEndDate(bJobV0.getJobEndDate());
        bJob.setJobIfEnd(bJobV0.getJobIfEnd());
        bJob.setDeleteFlag(bJobV0.getDeleteFlag());

        //boolean insert = ibJobService.save(bJob);// 新增作业
        List<String> ImgNo = bJobV0.getJobImgId();
//        String Str=ImgNo.toString().replace("[", "");
//        String str=Str.toString().replace("]", "");
//        bJob.setJobRemark(str);
        boolean insert = ibJobService.save(bJob);// 新增作业
        System.out.println("新增作业：" + insert);
        if(ImgNo.size() != 0){
            for (String imgsrc : ImgNo) {
                BJobImg jobImg = new BJobImg();
                jobImg.setJobId(bJob.getJobId());
                jobImg.setJobImgSrc(imgsrc.toString());
                JobImg.add(jobImg);
            }
            Boolean sava = this.iBJobImgService.saveBatch(JobImg);// 新增作业图片
            System.out.println("新增作业图片：" + sava);
        }
        System.out.println(bJobV0.getJobTeamId());
        if(bJobV0.getJobTeamId()!=null){
            List<String> TeamNo = bJobV0.getJobTeamId();
            if(TeamNo.size() != 0) {
                for (String teamId : TeamNo) {
                    QueryWrapper<BTeamdetail> queryWrapper = new QueryWrapper<>();
                    BJobTeam bJobTeam = new BJobTeam();
                    bJobTeam.setJobId(bJob.getJobId());
                    bJobTeam.setTeamId(teamId);
                    Boolean jobTeam =  ibJobTeamService.save(bJobTeam);
                    List<BTeamdetail> teamMemberList = ibTeamdetailService.list(new QueryWrapper<BTeamdetail>().eq("team_id", teamId));
                    for (BTeamdetail teamdetail : teamMemberList) {
//                        BLook blook = new BLook();
//                        blook.setJobId(bJob.getJobId());
//                        blook.setLookIf(0);
//                        blook.setTeamId(teamId);
//                        blook.setUserId(teamdetail.getUserCrewId());
//                        boolean Look = ibLookService.save(blook);
//                        System.out.println("新增查看：" + Look);
                        BSubmit bSubmit = new BSubmit();
                        bSubmit.setJobId(bJob.getJobId());
                        bSubmit.setUserId(teamdetail.getUserCrewId());
                        bSubmit.setTeamId(teamId);
                        bSubmit.setSubmitIf(0);
                        bSubmit.setSubmitLookIf(0);
                        boolean submit = ibSubmitService.save(bSubmit);
                        System.out.println("新增提交：" + submit);
                    }
                }
            }else{
                System.out.println("输出异常");
            }
        }else{
            System.out.println("新增分组和提交错误！");
        }
        String i = "succeed";
        return i;
    }

    /**
     *查看作业
     */
    @GetMapping(value = "/selectJoblist")
    @ResponseBody
    public List<BJob> selectJoblist(String userId) {
        //System.out.println(userId);
        //Result<List<StoreStockListVO>> result = new Result<>();
        List<BJob> pageList = ibJobService.selectJoblist(userId);
        //Integer integer = ibTeamService.selectAll();
        //System.out.println(pageList);
        return pageList;
    }

    /**
     *首页查看作业
     */
    @GetMapping(value = "/selectAllJobList")
    @ResponseBody
    public List<jobVo> selectAllJobList(String userId) {
        //System.out.println(userId);
        //Result<List<StoreStockListVO>> result = new Result<>();
        List<jobVo> pageList = ibJobService.selectAllJobList();
        //Integer integer = ibTeamService.selectAll();
        //System.out.println(pageList);
        return pageList;
    }

    /**
     *广场查看作业
     */
    @GetMapping(value = "/selectAllAJobList")
    @ResponseBody
    public List<jobVo> selectAllAJobList(String userId) {
        //System.out.println(userId);
        //Result<List<StoreStockListVO>> result = new Result<>();
        List<jobVo> pageList = ibJobService.selectAllAJobList();
        //Integer integer = ibTeamService.selectAll();
        //System.out.println(pageList);
        return pageList;
    }

    /**
     * 新建作业发布
     * @param bJobV0
     * @return
     */
//    @PostMapping("/jobInsert")
//    @ResponseBody
//    public String jobInsert(@RequestBody jobVo bJobV0){
//        BJob job = ibJobService.getOne(new QueryWrapper<BJob>().eq("job_id","edb7f6036c9c83056fde3140582d82a1"));
//        List<BJobImg> bJobImgs = JSONObject.parseArray(job.getJobRemark(), BJobImg.class);
//        for (BJobImg jobImg:bJobImgs) {
//            System.out.println(jobImg);
//        }
        //String z = "123";
//        System.out.println("发布组：" + bJobV0.getJobTeamId());
//        //System.out.println(bJobV0);
//        List<BJobImg> JobImg = new ArrayList<>();
//        //System.out.println(bJobV0);
//        BJob bJob = new BJob();
//        bJob.setUserId(bJobV0.getUserId());
//        bJob.setJobTitle(bJobV0.getJobTitle());
//        bJob.setJobCharacter(bJobV0.getJobCharacter());
//        bJob.setJobVoice(bJobV0.getJobVoice());
//        bJob.setJobPublishDate(new Date());
//        bJob.setJobEndDate(bJobV0.getJobEndDate());
//        bJob.setJobIfEnd(bJobV0.getJobIfEnd());
//        bJob.setDeleteFlag(bJobV0.getDeleteFlag());
//        List<String> imgNo = bJobV0.getJobImgId();
//        List<BJobImg> bJobImgs = new ArrayList<BJobImg>();
//        String imgString ="";
//        if (imgNo.size()>0){
//            for (String img:imgNo) {
//                BJobImg jobImg = new BJobImg();
//                jobImg.setJobId(bJob.getJobId());
//                jobImg.setJobImgSrc(img.toString());
//                bJobImgs.add(jobImg);
//            }
//            imgString = JSONObject.toJSONString(bJobImgs);
//        }
//        bJob.setJobRemark(imgString);
//        ibJobService.save(bJob);// 新增作业这段是新增作业的

//        if(imgNo.size() != 0){
//            for (int i = 0; i < ImgNo.size(); i++) {
//                BJobImg jobImg = new BJobImg();  //这是你的图片的对象，对吧，里面存得是图片信息，是不是是的
//                jobImg.setJobId(bJob.getJobId());
//                jobImg.setJobImgSrc(ImgNo.toString());
//                //System.out.println(ImgNo.toString());
//                JobImg.add(jobImg);
//            }  我给你演示一下
//            //Boolean sava = this.iBJobImgService.saveBatch(JobImg);// 新增作业图片你的意思
//        }
//        List<String> TeamNo = bJobV0.getJobTeamId();
//        if(TeamNo.size() != 0) {
//            System.out.println(TeamNo);
//            for (String teamId : TeamNo) {
//                QueryWrapper<BTeamdetail> queryWrapper = new QueryWrapper<>();
//                List<BTeamdetail> teamMemberList = ibTeamdetailService.list(new QueryWrapper<BTeamdetail>().eq("team_id", teamId));
//                for (BTeamdetail teamdetail : teamMemberList) {
//                    System.out.println(teamdetail.getUserCrewId());
//                }
//                System.out.println("每组数据分割线-----------------------------");
//            }
//        }else{
//            System.out.println("输出异常");
//        }
//            for (int i = 0; i < TeamNo.size(); i++) {
//                String[] split = TeamNo.toString().split(",");
//                System.out.println("切割长度：" + split.length);
//                BJobTeam bJobTeam = new BJobTeam();
//                bJobTeam.setJobId(bJob.getJobId());
//                bJobTeam.setTeamId(split[i].replace("[", "").replace("]",""));
//                boolean jobTeam = ibJobTeamService.save(bJobTeam);// 新增作业班组
//                String jobTeamId = bJobTeam.getJobTeamId();
//                System.out.println("新增入作业班组表Id：" + jobTeamId);
//                System.out.println("输入查询的ID：" + split[i].replace("[", "").replace("]",""));
//                System.out.println("结束！！！！！！！！！！！！！！！！！！！！");
//                QueryWrapper<BTeamdetail> queryWrapper = new QueryWrapper<>();

//                queryWrapper.lambda().like(BTeamdetail::getTeamId, split[i].replace("[", "").replace("]",""));
//                List<BTeamdetail> TeamVo = ibTeamdetailService.list(queryWrapper);
//                System.out.println("以下为查询数据！！！");
//                System.out.println(TeamVo);
//                for (BTeamdetail user:TeamVo) {
//                    System.out.println("用户Id；" + user.getUserCrewId());
//                    System.out.println("--------------------------------");
//                }
                //for (int z = 0; z < TeamVo.size(); z++) {
                //    System.out.println("新增进来了");
                    //System.out.println("添加作业：" + split[z].replace("[", "").replace("]",""));
                    //List<teamVo> TeamVo = ibTeamdetailService.selectteamdetaillist(split[z].replace("[", "").replace("]",""))
                //}
//            }
            //Boolean sava = this.iBJobImgService.saveBatch(JobImg);
//        }else{
//            System.out.println("班组没数值");
//        }
//        String i = bJob.getJobId();
//        return null;
//    }
}


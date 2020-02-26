package cn.fanqie.homework.submit.controller;


import cn.fanqie.homework.submit.Vo.submitVo;
import cn.fanqie.homework.submit.entity.BSubmit;
import cn.fanqie.homework.submit.entity.BSubmitdetail;
import cn.fanqie.homework.submit.service.IBSubmitService;
import cn.fanqie.homework.submit.service.IBSubmitdetailService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
 * 任务提交表：用户提交作业表 前端控制器
 * </p>
 *
 * @author liang
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/submit/b-submit")
public class BSubmitController extends BaseController {
    @Autowired
    private IBSubmitService ibSubmitService;
    @Autowired
    private IBSubmitdetailService ibSubmitdetailService;
    //文件上传
    @RequestMapping("/file_upload")
    public String saveFile(HttpServletRequest request) throws Exception {
        System.out.println("______________________文件上传——————————————————————————————————————————————");
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
     * 列表查询作业
     * @return
     */
    @GetMapping(value = "/selectsubmitlist")
    @ResponseBody
    public List<submitVo> selectsubmitlist(String userId) {
        //System.out.println("------------------------------");
        //System.out.println(userId);
        //Result<List<StoreStockListVO>> result = new Result<>();
        List<submitVo> pageList = ibSubmitService.selectsubmitlist(userId);
        //Integer integer = ibTeamService.selectAll();
        //System.out.println(pageList);
        return pageList;
    }

    /**
     * 学生作业提交
     * @param SubmitVo
     * @return
     */
    @PostMapping("/submitUpdata")
    @ResponseBody
    public Boolean submitUpdata(@RequestBody submitVo SubmitVo ){
        List<BSubmitdetail> JSubImg = new ArrayList<>();
        System.out.println(SubmitVo);
//        String submitId = request.getParameter("submitId");
//        String Character = request.getParameter("Character");
//        String Voice = request.getParameter("Voice");
//        String ImgSrc =  request.getParameter("dataImg");
//        System.out.println(submitId);
//        System.out.println(Character);
//        System.out.println(Voice);
//        System.out.println(ImgSrc);
        UpdateWrapper<BSubmit> storeStockUpdateWrapper = new UpdateWrapper<>();
        storeStockUpdateWrapper.eq("submit_id",SubmitVo.getSubmitId());
        BSubmit bUser = new BSubmit();
        bUser.setSubmitDate(new Date());
        bUser.setSubmitlCharacter(SubmitVo.getSubmitlCharacter());
        bUser.setSubmitVoice(SubmitVo.getSubmitVoice());
        bUser.setSubmitIf(1);

        List<String> ImgNo = SubmitVo.getJobImgId();
//        String Str=ImgNo.toString().replace("[", "").trim();
//        String str=Str.toString().replace("]", "").trim();
//        bUser.setSubmitRemark(str.trim());
        Boolean ok = ibSubmitService.update(bUser,storeStockUpdateWrapper);
        if(ImgNo.size() != 0){
            for (String imgsrc : ImgNo) {
                BSubmitdetail jobImg = new BSubmitdetail();
                jobImg.setSubmitId(SubmitVo.getSubmitId());
                jobImg.setSubmitdetailSrc(imgsrc.toString());
                JSubImg.add(jobImg);
            }
            Boolean sava = this.ibSubmitdetailService.saveBatch(JSubImg);// 新增作业图片
        }
        return ok;
    }

    /**
     *查看作业
     */
    @GetMapping(value = "/selectUserSublist")
    @ResponseBody
    public List<submitVo> selectUserSublist(String userId) {
        //System.out.println(userId);
        //Result<List<StoreStockListVO>> result = new Result<>();
        List<submitVo> pageList = ibSubmitService.selectUsersubmitlist(userId);
        List<submitVo> resultList =new ArrayList<>();
        for(int i=0;i<pageList.size();i++){
            submitVo submitVo=pageList.get(i);
            List<BSubmitdetail> pageList2 = ibSubmitdetailService.selectsubmitdetaillist(submitVo.getSubmitId());
            List<String> imgList=new ArrayList<>();
            for(int j=0;j<pageList2.size();j++){
                BSubmitdetail detail=pageList2.get(j);
                imgList.add(detail.getSubmitdetailSrc());
            }
            submitVo.setSubmitRemark(imgList);
            resultList.add(submitVo);
        }
        System.out.println(resultList);
        return pageList;
    }

    /**
     *广场查看作业
     */
    @GetMapping(value = "/selectUserjobSublist")
    @ResponseBody
    public List<submitVo> selectUserjobSublist(String userId) {
        //System.out.println(userId);
        //Result<List<StoreStockListVO>> result = new Result<>();
        List<submitVo> pageList = ibSubmitService.selectjobsubmitlist(userId);
        //Integer integer = ibTeamService.selectAll();
        System.out.println(pageList);
        return pageList;
    }

    /**
     *查看作业情况的总数
     */
    @GetMapping(value = "/selectUsersubmitNolist")
    @ResponseBody
    public List<submitVo> selectUsersubmitNolist(String jobId) {
        //System.out.println(jobId);
        //Result<List<StoreStockListVO>> result = new Result<>();
        List<submitVo> pageList = ibSubmitService.selectUsersubmitNolist(jobId);
        //System.out.println("查看作业情况的总数" + pageList.size());
        return pageList;
    }

    /**
     *作业发布后查看详情的情况
     */
    @GetMapping(value = "/selectsubmitcaselist")
    @ResponseBody
    public List<submitVo> selectsubmitcaselist(String jobId, boolean submiIf) {
        //System.out.println("传进来的作业ID：" + jobId);
        //System.out.println("传进来的作业ID：" + submiIf);
        //Result<List<StoreStockListVO>> result = new Result<>();
        List<submitVo> pageList = ibSubmitService.selectsubmitcaselist(jobId,submiIf);
        //Integer integer = ibTeamService.selectAll();
        //System.out.println(pageList);
        return pageList;
    }

    /**
     *作业发布后查看详情的情况
     */
    @GetMapping(value = "/selectUsersubmitcorrectlist")
    @ResponseBody
    public List<submitVo> selectUsersubmitcorrectlist(String jobId) {
//        System.out.println("传进来的作业ID：" + jobId);
//        System.out.println("传进来的作业ID：" + submiIf);
        //Result<List<StoreStockListVO>> result = new Result<>();
        List<submitVo> pageList = ibSubmitService.selectUsersubmitcorrectlist(jobId);
        //Integer integer = ibTeamService.selectAll();
//        System.out.println(pageList);
        return pageList;
    }

    /**
     *查看作业情况的总数
     */
    @GetMapping(value = "/selectUsersubmitOne")
    @ResponseBody
    public submitVo selectUsersubmitOne(String jobId) {
        System.out.println("作业情况的总数" + jobId);
        //Result<List<StoreStockListVO>> result = new Result<>();
        submitVo pageList = ibSubmitService.selectUsersubmitOnelist(jobId);
        System.out.println("查看作业情况的总数" + pageList);
        return pageList;
    }

    /**
     * 学生进入修改查看
     * @param submitid
     * @return
     */
    @PostMapping("/teachersubmitUpdatalookif")
    @ResponseBody
    public Boolean teachersubmitUpdatalookif(@RequestBody submitVo SubmitVo){
        System.out.println("修改提交的信息id；" + SubmitVo.getSubmitId());
        UpdateWrapper<BSubmit> storeStockUpdateWrapper = new UpdateWrapper<>();
        storeStockUpdateWrapper.eq("submit_id",SubmitVo.getSubmitId());
        BSubmit bUser = new BSubmit();
        bUser.setSubmitLookIf(1);
        Boolean ok = ibSubmitService.update(bUser,storeStockUpdateWrapper);
        return ok;
    }

    /**
     * 教师批改作业
     * @param SubmitVo
     * @return
     */
    @PostMapping("/teachersubmitUpdata")
    @ResponseBody
    public Boolean teachersubmitUpdata(@RequestBody submitVo SubmitVo ){
        System.out.println("修改作业的信息；" + SubmitVo);

        UpdateWrapper<BSubmit> storeStockUpdateWrapper = new UpdateWrapper<>();
        storeStockUpdateWrapper.eq("submit_id",SubmitVo.getSubmitId());
        BSubmit bUser = new BSubmit();
        bUser.setSubmitScore(SubmitVo.getSubmitScore());
        bUser.setSubmitMarkDate(new Date());
        bUser.setSubmitModify(1);
        bUser.setSubmitRemark(SubmitVo.getJobRemark());
        Boolean ok = ibSubmitService.update(bUser,storeStockUpdateWrapper);

        return ok;
    }
}


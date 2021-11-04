package edu.xww.spring.controller;

import edu.xww.beans.ErrorBean;
import edu.xww.beans.LoginBean;
import edu.xww.db.model.UserMaster;
import edu.xww.utils.Tools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Controller
@RequestMapping(value = "master", method = RequestMethod.POST)
public class UserMasterApiController extends PublicController {

    @Value("${system.upload.path}")
    private String uploadPath;

    @RequestMapping("loginDeal")
    @ResponseBody
    public ErrorBean loginDeal(@RequestBody LoginBean loginBean) {
        if (loginBean == null) {
            return ErrorBean.getInstance(1);
        }

        // 验证码
        if (!checkCode(loginBean.getTdCode())) {
            return ErrorBean.getInstance(2);
        }

        UserMaster master = masterService.findMasterByUsername(loginBean.getTdUsername());

        // 用户名不存在
        if (master == null) {
            return ErrorBean.getInstance(101);
        }

        // 用户名密码错误
        if (!Objects.equals(master.getMasterPassword(), Tools.md5(loginBean.getTdPassword()))) {
            return ErrorBean.getInstance(102);
        }

        //token错误
        if (!checkToken(loginBean.getToken())) {
            return ErrorBean.getInstance(3);
        }
        
        initMasterInfo(master);
        return ErrorBean.getInstance(0).setTitle("登陆成功").setMsg("登陆成功，即将跳转首页").setUrl("/master/index.do");
    }

    @RequestMapping("unlock")
    public String unlock(String password) {
        UserMaster master = (UserMaster) session.getAttribute("master");
        if (master == null) {
            master = masterService.findMasterByUsername(Tools.cookieValue(request, "loginUser"));
            if (master == null) return "redirect:/master/login.do";
        }
        if (master.getMasterPassword().equals(Tools.md5(password))) {
            //记录用户登录状态
            initMasterInfo(master);
            return "redirect:/master/index.do";
        }
        return "redirect:/master/lockScreen.do";
    }

    @RequestMapping("uploadFile")
    @ResponseBody
    public ErrorBean uploadFile(@RequestParam("files") MultipartFile[] multipartFiles) {
        if (multipartFiles == null) return ErrorBean.getInstance(1);
        if (multipartFiles.length != 1) return ErrorBean.getInstance(7);
        //定义文件的保存路径和访问路径
        String savePath = uploadPath;
        StringBuilder url = new StringBuilder("/upload/");
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        //拼接目录
        savePath += date + "\\";
        url.append(date).append("/");
        for (MultipartFile file : multipartFiles) {
            String saveName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            savePath += saveName;
            url.append(saveName);
            File saveFile = new File(savePath);
            saveFile.getParentFile().mkdirs();//避免目录不存在

            try (InputStream in = file.getInputStream(); OutputStream out = new FileOutputStream(savePath)) {
                FileCopyUtils.copy(in, out);
            } catch (Exception e) {
                LOG.error("文件上传失败", e);
                return ErrorBean.getInstance(6);
            }
        }
        return ErrorBean.getInstance(0).setUrl(url.toString());
    }
}

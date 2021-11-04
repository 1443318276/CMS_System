package edu.xww.spring.controller;

import edu.xww.db.model.UserMaster;
import edu.xww.db.service.*;
import edu.xww.spring.Application;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import edu.xww.utils.Tools;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class PublicController {
    protected Logger LOG = Logger.getLogger(this.getClass());
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected ModelMap modelMap;
    protected UserMaster loginUser;

    @Autowired
    protected UserMasterRuleService masterRuleService;
    @Autowired
    protected UserMasterService masterService;
    @Autowired
    protected UserRuleService ruleService;
    @Autowired
    protected UserRouterService routerService;
    @Autowired
    protected UserRouterRuleService routerRuleService;
    @Autowired
    protected SystemConfigService configService;
    @Autowired
    protected SystemTemplateService templateService;
    @Autowired
    protected ContentPageService pageService;
    @Autowired
    protected ContentArticleService articleService;
    @Autowired
    protected ContentTypeService typeService;

    @ModelAttribute
    public void _init(HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap modelMap) {
        this.request = request;
        this.response = response;
        this.session = session;
        this.modelMap = modelMap;
        loginUser = (UserMaster) session.getAttribute("loginUser");
        session.setAttribute("config", Application.getInstance().getConfigMap());
    }

    protected void createToken() {
        //生成随机字符串
        String sessionToken = Tools.randomStr(12);
        //记录sessionToken于session中
        session.setAttribute("sessionToken", sessionToken);
        //将sessionToken传递到页面
        modelMap.addAttribute("token", sessionToken);
    }

    protected void createCode() {
        //生成随机字符串
        String codeKey = Tools.randomStr(6, "0123456789");
        //记录codeKey于session中
        session.setAttribute("codeKey", codeKey);
        //将codeKey传递到页面
        modelMap.addAttribute("code", codeKey);
    }

    protected boolean checkToken(String token) {
        if (StringUtils.isEmpty(token)) return false;
        //从session中获取sessionToken
        String sessionToken = (String) session.getAttribute("sessionToken");
        session.removeAttribute("sessionToken");
        return token.equals(sessionToken);
    }

    protected boolean checkCode(String code) {
        if (StringUtils.isEmpty(code)) return false;
        String codeKey = (String) session.getAttribute("codeKey");
        return code.equalsIgnoreCase(codeKey); //验证码的验证需要忽略字符大小写
    }

    protected void initMasterInfo(UserMaster master) {
        session.setAttribute("loginUser", master);
        Cookie cookie = new Cookie("loginUser", master.getMasterUsername());
        cookie.setPath("/master");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 60 * 24 * 3);
        response.addCookie(cookie);
        session.removeAttribute("master");
    }
}

package edu.xww.spring.interceptor;

import edu.xww.db.model.UserMaster;
import edu.xww.db.service.UserMasterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import edu.xww.utils.Tools;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MasterLoginInterceptor extends HandlerInterceptorAdapter {

    private final Logger LOG = Logger.getLogger(this.getClass());

    @Value("${system.debug}")
    private boolean debug;

    @Resource
    private UserMasterService masterService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.debug("MasterLoginInterceptor:preHandle");
        //判断登录 使用session
        HttpSession session = request.getSession();
        if (session.getAttribute("loginUser") == null) {
            //从cookie中读取用户名
            String userName = Tools.cookieValue(request, "loginUser");
            UserMaster userMaster = masterService.findMasterByUsername(userName);
            if (userMaster != null) {
                //用户未登录-重定向用户到锁屏页面
                session.setAttribute("master", userMaster);
                response.sendRedirect("/master/lockScreen.do");
                return false;
            }
            if (debug) {
                UserMaster master = masterService.findByPrimaryKey(1);
                session.setAttribute("loginUser", master);
                return true;
            }
            //用户未登录-重定向用户到登录页面
            response.sendRedirect("/master/login.do");
            return false;
        }
        return true;
    }
}
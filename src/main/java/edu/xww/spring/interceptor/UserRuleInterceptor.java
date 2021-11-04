package edu.xww.spring.interceptor;

import edu.xww.db.model.UserMaster;
import edu.xww.db.service.UserRuleService;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRuleInterceptor extends HandlerInterceptorAdapter {
    private final Logger LOG = Logger.getLogger(this.getClass());

    @Resource
    private UserRuleService ruleService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        UserMaster master = (UserMaster) request.getSession().getAttribute("loginUser");
        if (master == null) return false;//用户未登录,阻止用户的访问
        //获取用户请求状态
        String method = request.getMethod();//GET POST PUT
        String uri =request.getRequestURI();//  /master/userRule.do
        //验证用户是否拥有访问权限,用户权限应该缓存于Redis中
        return ruleService.checkMasterRule(master,method,uri);
    }

}

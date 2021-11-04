package edu.xww.spring.controller;

import edu.xww.db.model.UserMaster;
import edu.xww.utils.Tools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;

@Controller
@RequestMapping(value = "master", method = RequestMethod.GET)
public class UserMasterController extends PublicController {

    @RequestMapping("index")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("ruleList", ruleService.selectPageListByMaster((UserMaster) session.getAttribute("loginUser")));
        return modelAndView;
    }

    @RequestMapping("login")
    public String login() {
        session.removeAttribute("loginUser");
        Cookie cookie = new Cookie("loginUser", null);
        cookie.setMaxAge(0);//用于删除cookie
        cookie.setHttpOnly(true);
        cookie.setPath("/master");
        response.addCookie(cookie);
        createCode();
        createToken();
        return "login";
    }

    @RequestMapping("lockScreen")
    public String lockScreen() {
        session.removeAttribute("loginUser");
        UserMaster master = (UserMaster) session.getAttribute("master");
        if (master == null) {
            master = masterService.findMasterByUsername(Tools.cookieValue(request, "loginUser"));
            if (master == null) return "redirect:/master/login.do";
            session.setAttribute("master", master);
        }
        return "lockScreen";
    }
}

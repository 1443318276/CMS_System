package edu.xww.spring.controller.router;

import edu.xww.spring.controller.PublicController;
import edu.xww.spring.service.UserRuleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "master", method = RequestMethod.GET)
public class RouterController extends PublicController {

    @RequestMapping("userRouter")
    public String userRouter() {
        return "user/router/list";
    }

    @RequestMapping("userRouterEdit")
    public String userRouterEdit(Integer id) {
        modelMap.addAttribute("id", id);
        modelMap.addAttribute("editItem", routerService.findByPrimaryKey(id));
        return "user/router/edit";
    }

    @RequestMapping("userRouterRule")
    public String userRouterRule() {
        modelMap.addAttribute("routerList", routerService.selectRouterList(loginUser));
        return "user/routerRule/list";
    }

    @RequestMapping("userRouterRuleEdit")
    public String userRouterRuleEdit(Integer id) {
        //写入id
        modelMap.addAttribute("id", id);
        //写入查询对象
        modelMap.addAttribute("editItem", routerRuleService.findByPrimaryKey(id));
        modelMap.addAttribute("routerList", routerService.selectRouterList(loginUser));
        modelMap.addAttribute("ruleList", UserRuleServiceImpl.childArrayToList(ruleService.selectAllRuleList()));
        return "user/routerRule/edit";
    }

}

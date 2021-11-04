package edu.xww.spring.controller.master;

import edu.xww.db.model.UserMaster;
import edu.xww.db.model.UserRouter;
import edu.xww.spring.controller.PublicController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "master", method = RequestMethod.GET)
public class MasterController extends PublicController {

    @RequestMapping("userMaster")
    public String userMaster() {
        UserMaster master = (UserMaster) session.getAttribute("loginUser");

        List<UserRouter> routerList = routerService.selectRouterList(master);
        modelMap.addAttribute("routerList", routerList);
        return "user/master/list";
    }

    @RequestMapping("userMasterEdit")
    public String userMasterEdit(Integer id) {
        UserMaster master = (UserMaster) session.getAttribute("loginUser");
        //添加用户所属角色
        List<UserRouter> routerList = routerService.selectRouterList(master);
        modelMap.addAttribute("routerList", routerList);
        //写入id
        modelMap.addAttribute("id", id);
        //写入查询对象
        modelMap.addAttribute("editItem", masterService.findByPrimaryKey(id));
        return "user/master/edit";
    }

    @RequestMapping("userMasterRule")
    public String userMasterRule() {
        modelMap.addAttribute("masterList", masterRuleService.selectMasterRule());
        return "user/masterRule/list";
    }

    @RequestMapping("userMasterRuleEdit")
    public String userMasterRuleEdit(Integer id) {
        return "user/masterRule/edit";
    }

}

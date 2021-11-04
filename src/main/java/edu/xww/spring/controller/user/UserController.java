package edu.xww.spring.controller.user;

import edu.xww.spring.controller.PublicController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "master", method = RequestMethod.GET)
public class UserController extends PublicController {

    @RequestMapping("userRule")
    public String userRule() {
        modelMap.addAttribute("ruleList", ruleService.selectAllParentList());
        return "user/rule/list";
    }

    @RequestMapping("userRuleEdit")
    public String userRuleEdit(Integer id) {
        modelMap.addAttribute("editItem", ruleService.findByPrimaryKey(id));
        modelMap.addAttribute("ruleList", ruleService.selectAllParentList());
        return "user/rule/edit";
    }

}

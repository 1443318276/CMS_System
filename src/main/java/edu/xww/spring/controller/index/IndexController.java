package edu.xww.spring.controller.index;

import edu.xww.spring.controller.PublicController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "", method = RequestMethod.GET)
public class IndexController extends PublicController {
    @RequestMapping("index")
    public String index() {
        modelMap.addAttribute("configList",configService.selectAllConfig());
        return "ftl/index";
    }
}

package edu.xww.spring.controller.system;

import edu.xww.db.model.SystemTemplate;
import edu.xww.spring.controller.PublicController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "master", method = RequestMethod.GET)
public class SystemController extends PublicController {

    @RequestMapping("systemConfig")
    public String systemConfig() {
        return "system/config/list";
    }

    @RequestMapping("systemConfigEdit")
    public String systemConfigEdit(Integer id) {
        //写入id
        modelMap.addAttribute("id", id);
        //写入查询对象
        modelMap.addAttribute("editItem", configService.findByPrimaryKey(id));
        return "system/config/edit";
    }

    @RequestMapping("systemTemplate")
    public String systemTemplate() {
        List<SystemTemplate> templateList = templateService.selectDistinctTypeList();
        if (templateList == null) templateList = new ArrayList<>();
        if (templateList.isEmpty()) {
            SystemTemplate template = new SystemTemplate();
            template.setTemplateType("default");
            templateList.add(template);
        }
        modelMap.addAttribute("templateTypeList", templateList);
        return "system/template/list";
    }

    @RequestMapping("systemTemplateEdit")
    public String systemTemplateEdit(Integer id) {
        //写入id
        modelMap.addAttribute("id", id);
        //写入查询对象
        modelMap.addAttribute("editItem", templateService.findByPrimaryKey(id));
        return "system/template/edit";
    }
}

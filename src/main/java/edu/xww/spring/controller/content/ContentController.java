package edu.xww.spring.controller.content;

import edu.xww.spring.controller.PublicController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "master", method = RequestMethod.GET)
public class ContentController extends PublicController {
    @RequestMapping("contentPage")
    public String contentPage() {
        return "content/page/list";
    }

    @RequestMapping("contentPageEdit")
    public String contentPageEdit(Integer id) {
        //写入查询对象
        modelMap.addAttribute("editItem", pageService.findByPrimaryKey(id));
        modelMap.addAttribute("templateList", templateService.selectAllTemplates());
        return "content/page/edit";
    }

    @RequestMapping("contentPageDetail")
    public String contentPageDetail(Integer id) {
        //写入查询对象
        modelMap.addAttribute("editItem", pageService.findByPrimaryKey(id));
        return "content/page/detail";
    }

    @RequestMapping("contentType")
    public String contentType() {
        return "content/type/list";
    }


    @RequestMapping("contentTypeEdit")
    public String contentTypeEdit(Integer id) {
        //写入查询对象
        modelMap.addAttribute("editItem", typeService.findByPrimaryKey(id));
        modelMap.addAttribute("typeList", typeService.selectAllTypeList());
        modelMap.addAttribute("templateList", templateService.selectAllTemplates());
        return "content/type/edit";
    }

    @RequestMapping("contentTypeDetail")
    public String contentTypeDetail(Integer id) {
        //写入查询对象
        modelMap.addAttribute("editItem", typeService.findByPrimaryKey(id));
        return "content/type/detail";
    }


    @RequestMapping("contentArticle")
    public String contentArticle() {
        return "content/article/list";
    }


    @RequestMapping("contentArticleEdit")
    public String contentArticleEdit(Integer id) {
        //写入查询对象
        modelMap.addAttribute("editItem", articleService.findByPrimaryKey(id));
        modelMap.addAttribute("templateList", templateService.selectAllTemplates());
        modelMap.addAttribute("typeList", typeService.selectAllTypeList());
        return "content/article/edit";
    }


    @RequestMapping("contentArticleDetail")
    public String contentArticleDetail(Integer id) {
        //写入查询对象
        modelMap.addAttribute("editItem", articleService.findByPrimaryKey(id));
        return "content/article/detail";
    }

    @RequestMapping("contentIndex")
    public String contentIndex() {
        return "content/index/list";
    }

    @RequestMapping("contentIndexDetail")
    public String contentIndexDetail() {
        //写入查询对象
        return "content/index/detail";
    }

}

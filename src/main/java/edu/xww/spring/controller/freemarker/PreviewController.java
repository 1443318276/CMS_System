package edu.xww.spring.controller.freemarker;


import edu.xww.db.model.ContentPage;
import edu.xww.db.model.ContentType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "master/preview", method = RequestMethod.GET)
public class PreviewController extends FreemarkerController {

    @RequestMapping("pageDetail")
    public String pageDetail(Integer id) {
        ContentPage page = pageService.findByPrimaryKey(id);
        pageData(modelMap, page);
        return templateStr(page).replace(".ftl", "");
    }

    @RequestMapping("typeDetail")
    public String pageDetail(Integer id, Integer pageNum) {
        pageNum = pageNum == null ? 1 : (pageNum < 1 ? 1 : pageNum);
        ContentType type = typeService.findByPrimaryKey(id);
        typeData(modelMap, type, pageNum);
        return templateStr(type).replace(".ftl", "");
    }


}

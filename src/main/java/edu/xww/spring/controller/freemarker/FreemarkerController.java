package edu.xww.spring.controller.freemarker;

import edu.xww.db.model.*;
import edu.xww.spring.Application;
import edu.xww.spring.controller.PublicController;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import edu.xww.beans.ErrorBean;

import java.io.File;
import java.util.List;
import java.util.Map;

public abstract class FreemarkerController extends PublicController {

    @Autowired
    @Qualifier("freeMarkerConfig")
    private FreeMarkerConfigurer freeMarkerConfigurer;

    protected <T extends BaseModel> String templateStr(T bean) {
        if (bean == null) return "default/empty.ftl";
        if (bean instanceof ContentPage) {
            ContentPage page = (ContentPage) bean;
            SystemTemplate template = templateService.findByPrimaryKey(page.getContentTemplate());
            if (template != null) return template.getTemplateDir() + "/" + template.getTemplateFile();
            return "default/detail.ftl";
        } else if (bean instanceof ContentType) {
            ContentType type = (ContentType) bean;
            SystemTemplate template = templateService.findByPrimaryKey(type.getTypeTemplate());
            if (template != null) return template.getTemplateDir() + "/" + template.getTemplateFile();
            return "default/list.ftl";
        }
        return "default/404.ftl";
    }

    protected ErrorBean createHtml(String defaultTemplateFile, String htmlSaveFile, Map<String, Object> dateMap) {
        //确保路径存在
        File htmlDir = new File(htmlSaveFile).getParentFile();
        if (!htmlDir.exists()) htmlDir.mkdirs();
        try (FileWriterWithEncoding out = new FileWriterWithEncoding(htmlSaveFile, "UTF-8")) {
            //使用freemarker创建静态文件
            Configuration configuration = freeMarkerConfigurer.getConfiguration();
            //获取模板
            Template configurationTemplate = configuration.getTemplate(defaultTemplateFile);

            configurationTemplate.process(dateMap, out);
        } catch (Exception e) {
            LOG.error("模板生成失败", e);
            return ErrorBean.getInstance(203);
        }
        return ErrorBean.getInstance(0);
    }

    protected void pageData(Map<String, Object> dataMap, ContentPage page) {
        dataMap.put("config", Application.getInstance().getConfigMap());
        dataMap.put("page", page);
    }

    protected void typeData(Map<String, Object> dataMap, ContentType type, Integer pageNum) {
        typeData(dataMap, type, pageNum, articleService.selectArticleListByTypeWithPageNumber(type, pageNum));
    }

    protected void typeData(Map<String, Object> dataMap, ContentType type, Integer pageNum, List<ContentArticle> articleList) {
        dataMap.put("config", Application.getInstance().getConfigMap());
        dataMap.put("type", type);
        dataMap.put("pageNum", pageNum);
        //文章分类下的文章列表
        dataMap.put("articleList", articleList);
        //写入文章分类
        dataMap.put("typeList", typeService.selectTypeListWithParentsAndChild(type));
    }

}


package edu.xww.spring.controller.freemarker;

import edu.xww.db.model.ContentPage;
import edu.xww.db.model.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.xww.beans.ErrorBean;
import edu.xww.beans.PublishBean;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@RequestMapping(value = "master/html", method = RequestMethod.POST)
@Controller
public class HtmlController extends FreemarkerController {
    @Value("${system.freemarker.staticPath}")
    private String htmlPath;

    @Value("${system.freemarker.loaderPath}")
    private String loaderPath;

    @RequestMapping("publish")
    @ResponseBody
    public ErrorBean publish(@RequestBody PublishBean bean) {
        switch (bean.getType()) {
            case "site":
                //发布全站
                break;
            case "index":
                //发布首页
                break;
            case "contentType":
                //发布文章分类
                return typeToHtml(bean.getIdList(),bean.getCategory());
            case "contentArticle":
                //发布文章
                break;
            case "page":
                return pageToHtml(bean.getIdList(), bean.getCategory());
        }
        return ErrorBean.getInstance(0);
    }

    private ErrorBean typeToHtml(List<Integer> idList, String category) {
        ErrorBean errorBean = ErrorBean.getInstance(0);
        List<ErrorBean> errorBeanList = new LinkedList<>();
        errorBean.setExtra(errorBeanList);
        switch (category) {
            case "all":
                List<ContentType> typeList = typeService.selectAllContentTypeWithBlobs();
                for (ContentType type : typeList) {
                    ErrorBean bean = typeDetail(type);
                    errorBean.setCode(errorBean.getCode() + bean.getCode());
                    errorBeanList.add(bean);
                }
                break;
            case "multiple":
                if (idList != null) {
                    for (Integer entity : idList) {
                        ErrorBean bean = pageDetail(entity);
                        errorBean.setCode(errorBean.getCode() + bean.getCode());
                        errorBeanList.add(bean);
                    }
                } else {
                    errorBean = ErrorBean.getInstance(201);
                }
                break;
            case "single":
                if (idList != null && !idList.isEmpty()) {
                    errorBean = pageDetail(idList.get(0));
                } else {
                    errorBean = ErrorBean.getInstance(201);
                }
        }
        return errorBean;
    }


    private ErrorBean pageToHtml(List<Integer> idList, String category) {
        ErrorBean errorBean = ErrorBean.getInstance(0);
        List<ErrorBean> errorBeanList = new LinkedList<>();
        errorBean.setExtra(errorBeanList);
        switch (category) {
            case "all":
                List<ContentPage> pageList = pageService.selectAllContentPageWithBlobs();
                for (ContentPage page : pageList) {
                    ErrorBean bean = pageDetail(page);
                    errorBean.setCode(errorBean.getCode() + bean.getCode());
                    errorBeanList.add(bean);
                }
                break;
            case "multiple":
                if (idList != null) {
                    for (Integer entity : idList) {
                        ErrorBean bean = pageDetail(entity);
                        errorBean.setCode(errorBean.getCode() + bean.getCode());
                        errorBeanList.add(bean);
                    }
                } else {
                    errorBean = ErrorBean.getInstance(201);
                }
                break;
            case "single":
                if (idList != null && !idList.isEmpty()) {
                    errorBean = pageDetail(idList.get(0));
                } else {
                    errorBean = ErrorBean.getInstance(201);
                }
        }
        return errorBean;
    }

    private ErrorBean pageDetail(Integer id) {
        return pageDetail(pageService.findByPrimaryKey(id));
    }
    private ErrorBean typeDetail(ContentType type) {
        return ErrorBean.getInstance(0);
    }

    private ErrorBean pageDetail(ContentPage page) {
        if (page == null) return ErrorBean.getInstance(201);
        Map<String, Object> dateMap = new HashMap<>();
        pageData(dateMap,page);
        //准备模板文件
        String htmlSaveFile = htmlPath + "page_" + page.getId() + ".html";
        //开始写入html
        return createHtml(templateStr(page), htmlSaveFile, dateMap);
    }

}

/*
package edu.td.peanut.controller.freemarker;

import db.model.*;
import edu.td.peanut.Application;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import edu.xww.beans.ErrorBean;
import edu.xww.beans.PublishBean;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@RequestMapping(value = "master/html", method = RequestMethod.POST)
@Controller
public class HtmlController extends FreemarkerController {
    @Value("${system.freemarker.staticPath}")
    private String htmlPath;

    @Value("${system.freemarker.loaderPath}")
    private String loaderPath;

    @RequestMapping("publish")
    @ResponseBody
    public ErrorBean publish(@RequestBody PublishBean publishBean) {
        List<Integer> idList = publishBean.getIdList();
        String category = publishBean.getCategory();
        String type = publishBean.getType();
        switch (type) {
            case "site": //发布全站
                break;
            case "index"://发布首页
                break;
        }
        ErrorBean errorBean = ErrorBean.getInstance(0);
        List<ErrorBean> errorBeanList = new LinkedList<>();
        errorBean.setExtra(errorBeanList);
        switch (category) {
            case "all":
                List<? extends BaseModel> contentList = null;

                for (BaseModel model : contentList) {
                    ErrorBean bean = detail(model);
                    errorBean.setCode(errorBean.getCode() + bean.getCode());
                    errorBeanList.add(bean);
                }
                break;
            case "multiple":
                if (idList != null) {
                    for (Integer entity : idList) {
                        ErrorBean bean = detail(entity, type);
                        errorBean.setCode(errorBean.getCode() + bean.getCode());
                        errorBeanList.add(bean);
                    }
                } else {
                    errorBean = ErrorBean.getInstance(201);
                }
                break;
            case "single":
                if (idList != null && !idList.isEmpty()) {
                    errorBean = detail(idList.get(0), type);
                } else {
                    errorBean = ErrorBean.getInstance(201);
                }
        }
        return errorBean;
    }

    private ErrorBean detail(Integer id, String type) {
        switch (type) {
            case "contentType"://发布文章分类
                return typeDetail(typeService.findByPrimaryKey(id));

            break;
            case "contentArticle"://发布文章
                return articleDetail(articleService.findByPrimaryKey(id));
            break;
            case "page"://发布独立页面
                return pageDetail(pageService.findByPrimaryKey(id));
            break;
        }
        return null;
    }

    private ErrorBean detail(BaseModel model) {
        if (model instanceof ContentType) {
            return typeDetail((ContentType) model);
        } else if (model instanceof ContentArticle) {
            return articleDetail((ContentArticle) model);
        } else if (model instanceof ContentPage) {
            return pageDetail((ContentPage) model);
        }
        return null;
    }

    private ErrorBean pageDetail(ContentPage page) {
        if (page == null) return ErrorBean.getInstance(201);
        Map<String, Object> dateMap = new HashMap<>();
        pageData(dateMap, page);
        //准备模板文件
        String htmlSaveFile = htmlPath + "page_" + page.getId() + ".html";
        //开始写入html
        return createHtml(templateStr(page), htmlSaveFile, dateMap);
    }

    private ErrorBean typeDetail(ContentType type) {
        if (type == null) return ErrorBean.getInstance(201);
        Map<String, Object> dateMap = new HashMap<>();
        //查询分类下所有文章
        List<ContentArticle> articleList = articleService.selectArticleWithBlobsByType(type);
        int total = articleList.size();
        int totalPage = total / 10 + (total % 10 == 0 ? 0 : 1);
        //需要生成分页 1：生成首页
        String htmlSaveFile = htmlPath + type.getTypeFolder() + File.separator + "index.html";
        typeData(dateMap, type, 1,articleList.subList(0,(total>=10?10:total)));
        createHtml(templateStr(type), htmlSaveFile, dateMap);
        if (totalPage > 1) {
            //需要生成分页 2：按页码生成对应页面
            for (int pageNumber = 1; pageNumber <= totalPage; pageNumber++) {
                htmlSaveFile = htmlPath + type.getTypeFolder() + File.separator + String.format("list_page_%d.html", pageNumber);
                int startIndex=(pageNumber-1)*10;
                int endIndex=pageNumber*10;
                endIndex=endIndex>total?total:endIndex;
                typeData(dateMap, type, pageNumber,articleList.subList(startIndex,endIndex));
                createHtml(templateStr(type), htmlSaveFile, dateMap);
            }
        }
        //生成文章详情页
        articleList.forEach(entity -> articleDetail(entity, type));
        return null;
    }

    private ErrorBean articleDetail(ContentArticle article) {
        return articleDetail(article, typeService.findByPrimaryKey(article.getTypeId()));
    }

    private ErrorBean articleDetail(ContentArticle article, ContentType type) {
        return null;
    }
}


 */

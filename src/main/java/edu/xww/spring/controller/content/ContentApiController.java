package edu.xww.spring.controller.content;

import edu.xww.db.model.ContentArticle;
import edu.xww.db.model.ContentPage;
import edu.xww.db.model.ContentType;
import edu.xww.spring.controller.PublicController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;
import edu.xww.beans.DeleteBean;
import edu.xww.beans.ErrorBean;

@Controller
@RequestMapping(value = "master", method = RequestMethod.POST)
public class ContentApiController extends PublicController {

    @RequestMapping("contentPageData")
    @ResponseBody
    public BootsTableResponse<ContentPage> contentPageData(@RequestBody BootsTableRequest tableRequest) {
        return pageService.bootsData(tableRequest);
    }

    @RequestMapping("editContentPage")
    @ResponseBody
    public ErrorBean editContentPage(@RequestBody ContentPage record) {
        if (record == null) return ErrorBean.getInstance(1);
        record.setPageContent(null);
        int resultLines;//返回数据影响的行数
        if (record.isInsert()) {
            resultLines = pageService.insertSelective(record);
        } else {
            resultLines = pageService.updateByPrimaryKey(record);
        }
        if (resultLines > 0)
            return ErrorBean.getInstance(0).setUrl(String.format("/master/contentPageDetail.do?id=%d", record.getId())).setTitle(record.getPageName());
        return ErrorBean.getInstance(4);
    }

    @RequestMapping("editContentPageDetail")
    @ResponseBody
    public ErrorBean editContentPageDetail(@RequestBody ContentPage record) {
        if (record == null) return ErrorBean.getInstance(1);
        ContentPage contentRecord = new ContentPage();
        contentRecord.setId(record.getId());
        contentRecord.setPageContent(record.getPageContent());
        if (pageService.updateByPrimaryKey(contentRecord) > 0) return ErrorBean.getInstance(0);
        return ErrorBean.getInstance(4);
    }

    @RequestMapping("delContentPage")
    @ResponseBody
    public ErrorBean delContentPage(@RequestBody DeleteBean deleteBean) {
        if (deleteBean == null) return ErrorBean.getInstance(1);
        if (pageService.delElementByIdList(deleteBean.getIdList()) > 0) {
            return ErrorBean.getInstance(0);
        }
        return ErrorBean.getInstance(5);
    }


    @RequestMapping("contentTypeData")
    @ResponseBody
    public Object contentTypeData(@RequestBody BootsTableRequest tableRequest) {
        return typeService.bootsData(tableRequest);
    }

    @RequestMapping("editContentType")
    @ResponseBody
    public ErrorBean editContentType(@RequestBody ContentType record) {
        if (record == null) return ErrorBean.getInstance(1);
        record.setTypeContent(null);
        int resultLines;//返回数据影响的行数
        if (record.isInsert()) {
            resultLines = typeService.insertSelective(record);
        } else {
            resultLines = typeService.updateByPrimaryKey(record);
        }
        if (resultLines > 0)
            return ErrorBean.getInstance(0).setUrl(String.format("/master/contentTypeDetail.do?id=%d", record.getId())).setTitle(record.getTypeName());
        return ErrorBean.getInstance(4);
    }


    @RequestMapping("editContentTypeDetail")
    @ResponseBody
    public ErrorBean editContentTypeDetail(@RequestBody ContentType record) {
        if (record == null) return ErrorBean.getInstance(1);
        ContentType contentRecord = new ContentType();
        contentRecord.setId(record.getId());
        //TODO 对内容进行校验,以防js注入
        contentRecord.setTypeContent(record.getTypeContent());
        if (typeService.updateByPrimaryKey(contentRecord) > 0) return ErrorBean.getInstance(0);
        return ErrorBean.getInstance(4);
    }


    @RequestMapping("delContentType")
    @ResponseBody
    public ErrorBean delContentType(@RequestBody DeleteBean deleteBean) {
        if (deleteBean == null) return ErrorBean.getInstance(1);
        if (typeService.delElementByIdList(deleteBean.getIdList()) > 0) {
            return ErrorBean.getInstance(0);
        }
        return ErrorBean.getInstance(5);
    }


    @RequestMapping("contentArticleData")
    @ResponseBody
    public BootsTableResponse<ContentArticle> contentArticleData(@RequestBody BootsTableRequest tableRequest) {
        return articleService.bootsData(tableRequest);
    }

    @RequestMapping("editContentArticle")
    @ResponseBody
    public ErrorBean editContentArticle(@RequestBody ContentArticle record) {
        if (record == null) return ErrorBean.getInstance(1);
        record.setArticleContent(null);
        int resultLines;//返回数据影响的行数
        if (record.isInsert()) {
            resultLines = articleService.insertSelective(record);
        } else {
            resultLines = articleService.updateByPrimaryKey(record);
        }
        if (resultLines > 0)
            return ErrorBean.getInstance(0).setUrl(String.format("/master/contentArticleDetail.do?id=%d", record.getId())).setTitle(record.getArticleName());
        return ErrorBean.getInstance(4);
    }


    @RequestMapping("editContentArticleDetail")
    @ResponseBody
    public ErrorBean editContentArticleDetail(@RequestBody ContentArticle record) {
        if (record == null) return ErrorBean.getInstance(1);
        ContentArticle contentRecord = new ContentArticle();
        contentRecord.setId(record.getId());
        //TODO 对内容进行校验,以防js注入
        contentRecord.setArticleContent(record.getArticleContent());
        if (articleService.updateByPrimaryKey(contentRecord) > 0) return ErrorBean.getInstance(0);
        return ErrorBean.getInstance(4);
    }


    @RequestMapping("delContentArticle")
    @ResponseBody
    public ErrorBean delContentArticle(@RequestBody DeleteBean deleteBean) {
        if (deleteBean == null) return ErrorBean.getInstance(1);
        if (articleService.delElementByIdList(deleteBean.getIdList()) > 0) {
            return ErrorBean.getInstance(0);
        }
        return ErrorBean.getInstance(5);
    }


    @RequestMapping("editContentIndexDetail")
    @ResponseBody
    public ErrorBean editContentIndexDetail() {
        return ErrorBean.getInstance(0);
    }


}

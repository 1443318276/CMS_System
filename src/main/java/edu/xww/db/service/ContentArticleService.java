package edu.xww.db.service;

import edu.xww.db.model.ContentArticle;
import edu.xww.db.model.ContentType;

import java.util.List;

public interface ContentArticleService extends BaseService<ContentArticle> {
    List<ContentArticle> selectArticleListByTypeWithPageNumber(ContentType type, Integer pageNum);
}

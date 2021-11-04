package edu.xww.spring.service;

import com.github.pagehelper.PageHelper;
import edu.xww.db.mapper.ContentArticleMapper;
import edu.xww.db.model.ContentArticle;
import edu.xww.db.model.ContentArticleExample;
import edu.xww.db.model.ContentType;
import edu.xww.db.service.AbstractService;
import edu.xww.db.service.ContentArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;

import java.util.List;

@Service
@Primary
public class ContentArticleServiceImpl extends AbstractService implements ContentArticleService {

    @Autowired
    private ContentArticleMapper articleMapper;

    @Override
    public ContentArticle findByPrimaryKey(Integer key) {
        if (key == null || key < 1) return null;
        return articleMapper.selectByPrimaryKey(key);
    }

    @Override
    public int insertSelective(ContentArticle record) {
        if (record == null) return 0;
        return articleMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(ContentArticle record) {
        if (record == null) return 0;
        return articleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delElementByIdList(List<Integer> idList) {
        if (idList == null || idList.isEmpty()) return 0;
        ContentArticleExample example = new ContentArticleExample();
        example.createCriteria().andIdIn(idList);
        return articleMapper.updateByExampleSelective(newDelInstance(ContentArticle.class), example);
    }

    @Override
    public BootsTableResponse<ContentArticle> bootsData(BootsTableRequest tableRequest) {
        ContentArticleExample example = new ContentArticleExample();
        ContentArticleExample.Criteria criteria = example.createCriteria();
        criteria.andDelTimeEqualTo(0);
        if (!StringUtils.isEmpty(tableRequest.getSearch())) {
            criteria.andArticleNameLike(tableRequest.getSearch());
        }
        if (StringUtils.isEmpty(tableRequest.getSort())) {
            example.setOrderByClause("add_time desc");
        } else {
            example.setOrderByClause(tableRequest.getSort() + " " + tableRequest.getOrder());
        }
        PageHelper.offsetPage(tableRequest.getOffset(), tableRequest.getLimit());
        return new BootsTableResponse<>(articleMapper.selectByExample(example));
    }

    @Override
    public List<ContentArticle> selectArticleListByTypeWithPageNumber(ContentType type, Integer pageNum) {
        ContentArticleExample example = new ContentArticleExample();
        example.createCriteria()
                .andTypeIdEqualTo(type.getId())
                .andDelTimeEqualTo(0);
        PageHelper.startPage(pageNum, 10);
        return articleMapper.selectByExample(example);
    }
}


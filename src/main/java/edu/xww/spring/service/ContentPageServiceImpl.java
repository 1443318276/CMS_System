package edu.xww.spring.service;

import com.github.pagehelper.PageHelper;
import edu.xww.db.mapper.ContentPageMapper;
import edu.xww.db.model.ContentPage;
import edu.xww.db.model.ContentPageExample;
import edu.xww.db.service.AbstractService;
import edu.xww.db.service.ContentPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;

import java.util.List;

@Service
@Primary
public class ContentPageServiceImpl extends AbstractService implements ContentPageService {
    @Autowired
    private ContentPageMapper pageMapper;

    @Override
    public ContentPage findByPrimaryKey(Integer key) {
        if (key == null || key < 1) return null;
        return pageMapper.selectByPrimaryKey(key);
    }

    @Override
    public int insertSelective(ContentPage record) {
        if (record == null) return 0;
        record.prepareEdit();
        return pageMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(ContentPage record) {
        if (record == null) return 0;
        record.prepareEdit();
        return pageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delElementByIdList(List<Integer> idList) {
        if (idList == null || idList.isEmpty()) return 0;
        ContentPageExample example = new ContentPageExample();
        example.createCriteria().andIdIn(idList);
        return pageMapper.updateByExampleSelective(newDelInstance(ContentPage.class), example);
    }

    @Override
    public BootsTableResponse<ContentPage> bootsData(BootsTableRequest tableRequest) {
        if (tableRequest == null) return null;
        ContentPageExample example = new ContentPageExample();
        ContentPageExample.Criteria criteria = example.createCriteria();
        criteria.andDelTimeEqualTo(0);
        PageHelper.offsetPage(tableRequest.getOffset(), tableRequest.getLimit());
        return new BootsTableResponse<>(pageMapper.selectByExample(example));
    }

    @Override
    public List<ContentPage> selectAllContentPageWithBlobs() {
        ContentPageExample example = new ContentPageExample();
        ContentPageExample.Criteria criteria = example.createCriteria();
        criteria.andDelTimeEqualTo(0);
        return pageMapper.selectByExampleWithBLOBs(example);
    }
}

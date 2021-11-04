package edu.xww.spring.service;

import com.github.pagehelper.PageHelper;
import edu.xww.db.mapper.ContentTypeMapper2;
import edu.xww.db.model.ContentType;
import edu.xww.db.model.ContentTypeExample;
import edu.xww.db.model.ContentTypeWithParent;
import edu.xww.db.service.AbstractService;
import edu.xww.db.service.ContentTypeService;
import edu.xww.db.service.SystemTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Primary

public class ContentTypeServiceImpl extends AbstractService implements ContentTypeService {
    @Autowired
    private ContentTypeMapper2 typeMapper;
    @Autowired
    private SystemTemplateService templateService;

    @Override
    public ContentType findByPrimaryKey(Integer key) {
        if (key == null || key < 1) return null;
        return typeMapper.selectByPrimaryKey(key);
    }

    @Override
    public int insertSelective(ContentType record) {
        if (record == null) return 0;
        ContentType parentType = findByPrimaryKey(record.getPid());
        if (parentType == null) {
            record.setLevel(1);
        } else {
            record.setLevel(parentType.getLevel() + 1);
        }
        return typeMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(ContentType record) {
        if (record == null) return 0;
//注意pid为空
        if (record.getTypeContent() == null) {
            ContentType parentType = findByPrimaryKey(record.getPid());
            if (parentType == null) {
                record.setLevel(1);
            } else {
                record.setLevel(parentType.getLevel() + 1);
            }
        }
        return typeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delElementByIdList(List<Integer> idList) {
        if (idList == null || idList.isEmpty()) return 0;
        ContentTypeExample example = new ContentTypeExample();
        example.createCriteria().andIdIn(idList);
        return typeMapper.updateByExampleSelective(newDelInstance(ContentType.class), example);
    }

    @Override
    public BootsTableResponse<ContentType> bootsData(BootsTableRequest tableRequest) {
        ContentTypeExample example = new ContentTypeExample();
        ContentTypeExample.Criteria criteria = example.createCriteria();
        criteria.andDelTimeEqualTo(0);
        Integer pid = tableRequest.getInteger("pid");
        if (pid == null || pid < 1) {
            if (StringUtils.isEmpty(tableRequest.getSearch())) {
                criteria.andPidIsNull();
            } else {
                criteria.andTypeNameLike(tableRequest.getSearch());
            }
            PageHelper.offsetPage(tableRequest.getOffset(), tableRequest.getLimit());
        } else {
            criteria.andPidEqualTo(pid);
        }
        if (StringUtils.isEmpty(tableRequest.getSort())) {

            example.setOrderByClause("add_time desc");
        } else {
            example.setOrderByClause(tableRequest.getSort() + " " + tableRequest.getOrder());
        }
        BootsTableResponse<ContentType> response = new BootsTableResponse<>(typeMapper.selectByExample(example));
        response.getRows().forEach(entity -> {
            Map<String, Object> extraMap = new HashMap<>();
            entity.setExtra(extraMap);
            extraMap.put("contentTemplate", templateService.findByPrimaryKey(entity.getContentTemplate()));
            extraMap.put("typeTemplate", templateService.findByPrimaryKey(entity.getTypeTemplate()));
            extraMap.put("parentType", findParentType(entity));
        });
        return response;
    }

    @Override
    public List<ContentType> selectAllTypeList() {
        ContentTypeExample example = new ContentTypeExample();
        example.createCriteria().andDelTimeEqualTo(0);
        return typeMapper.selectByExample(example);
    }

    @Override
    public ContentTypeWithParent findParentType(ContentType type) {
        if (type == null || type.getPid() == null) return null;
        return typeMapper.findByPrimaryKeyWithParent(type.getPid());
    }

    @Override
    public List<ContentTypeWithParent> selectTypeListWithParentsAndChild(ContentType type) {
        type = findTopType(type);
        return typeMapper.selectTypeListWithChild(type.getId());
    }

    @Override
    public List<ContentType> selectAllContentTypeWithBlobs() {
        return null;
    }

    private ContentType findTopType(ContentType type) {
        ContentTypeWithParent typeWithParent = findParentType(type);
        if (typeWithParent == null) return type;
        return findTop(typeWithParent);
    }

    private ContentTypeWithParent findTop(ContentTypeWithParent typeWithParent) {
        if (typeWithParent.getParentType() == null) return typeWithParent;
        return findTop(typeWithParent.getParentType());
    }
}

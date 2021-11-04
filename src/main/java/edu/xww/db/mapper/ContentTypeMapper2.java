package edu.xww.db.mapper;

import edu.xww.db.model.ContentTypeWithParent;

import java.util.List;

public interface ContentTypeMapper2 extends ContentTypeMapper {
    ContentTypeWithParent findByPrimaryKeyWithParent(Integer key);

    List<ContentTypeWithParent> selectTypeListWithChild(Integer id);
    
    List<ContentTypeWithParent> selectTypeListWithParentId(Integer pid);
}

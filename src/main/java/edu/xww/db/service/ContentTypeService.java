package edu.xww.db.service;

import edu.xww.db.model.ContentType;
import edu.xww.db.model.ContentTypeWithParent;

import java.util.List;

public interface ContentTypeService extends BaseService<ContentType> {
    List<ContentType> selectAllTypeList();

    ContentTypeWithParent findParentType(ContentType type);

    List< ContentTypeWithParent> selectTypeListWithParentsAndChild(ContentType type);

    List<ContentType> selectAllContentTypeWithBlobs();
}

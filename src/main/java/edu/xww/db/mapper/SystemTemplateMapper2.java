package edu.xww.db.mapper;

import edu.xww.db.model.SystemTemplate;

import java.util.List;

public interface SystemTemplateMapper2 extends SystemTemplateMapper {
    List<SystemTemplate> selectDistinctTypeList();
}

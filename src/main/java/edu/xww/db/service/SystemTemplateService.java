package edu.xww.db.service;

import edu.xww.db.model.SystemTemplate;

import java.util.List;

public interface SystemTemplateService extends BaseService<SystemTemplate> {
    List<SystemTemplate> selectDistinctTypeList();

    List<SystemTemplate> selectAllTemplates();
}

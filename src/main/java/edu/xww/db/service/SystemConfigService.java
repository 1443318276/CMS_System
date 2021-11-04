package edu.xww.db.service;

import edu.xww.db.model.SystemConfig;

import java.util.List;

public interface SystemConfigService extends BaseService<SystemConfig> {
    List<SystemConfig> selectAllConfig();
}


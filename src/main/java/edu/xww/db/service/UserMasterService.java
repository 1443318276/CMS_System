package edu.xww.db.service;

import edu.xww.db.model.UserMaster;

public interface UserMasterService extends BaseService<UserMaster>{
    UserMaster findMasterByUsername(String userName);
}

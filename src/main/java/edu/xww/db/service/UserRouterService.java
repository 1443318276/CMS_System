package edu.xww.db.service;

import edu.xww.db.model.UserMaster;
import edu.xww.db.model.UserRouter;

import java.util.List;

public interface UserRouterService extends BaseService<UserRouter> {
    List<UserRouter> selectRouterList(UserMaster master);
}

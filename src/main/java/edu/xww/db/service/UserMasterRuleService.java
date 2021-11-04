package edu.xww.db.service;

import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;
import edu.xww.db.model.UserMasterRule;
import edu.xww.db.model.ViewRouterRule;

import java.util.List;

public interface UserMasterRuleService extends BaseService<UserMasterRule> {
    List<UserMasterRule> selectMasterRule();

    BootsTableResponse<ViewRouterRule> ViewBootsData(BootsTableRequest tableRequest);
}

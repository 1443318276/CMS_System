package edu.xww.db.service;

import edu.xww.db.model.UserRouterRule;
import edu.xww.db.model.ViewRouterRule;
import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;

public interface UserRouterRuleService extends BaseService<UserRouterRule> {
    BootsTableResponse<ViewRouterRule> ViewBootsData(BootsTableRequest tableRequest);
}

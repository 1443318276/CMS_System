package edu.xww.db.service;

import edu.xww.db.model.UserMaster;
import edu.xww.db.model.UserRule;
import edu.xww.db.model.UserRule2;

import java.util.List;

public interface UserRuleService extends BaseService<UserRule> {
    /**
     * 查询所有的可作为父级权限列表
     *
     * @return 除了API之外所有的GET权限
     */
    List<UserRule> selectAllParentList();

    /**
     * 验证管理员权限，是否放行
     *
     * @param master 需要验证的管理员，一般情况验证的都是登录用户
     * @param method POST GET PUT
     * @param uri    无域名的请求路径 /master/index.do
     * @return true false
     */

    boolean checkMasterRule(UserMaster master, String method, String uri);

    List<UserRule2> selectPageListByMaster(UserMaster master);

    List<UserRule2> selectAllRuleList();
}
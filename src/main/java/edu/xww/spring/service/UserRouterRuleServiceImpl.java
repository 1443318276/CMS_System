package edu.xww.spring.service;

import com.github.pagehelper.PageHelper;
import edu.xww.db.mapper.*;
import edu.xww.db.model.UserRouterRule;
import edu.xww.db.model.ViewRouterRule;
import edu.xww.db.service.AbstractService;
import edu.xww.db.service.UserRouterRuleService;
import org.mybatis.dynamic.sql.select.join.EqualTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;

import java.util.List;

import static edu.xww.db.mapper.UserRouterRuleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
@Primary
public class UserRouterRuleServiceImpl extends AbstractService implements UserRouterRuleService {
    @Autowired
    private UserRouterRuleMapper routerRuleMapper;
    @Autowired
    private ViewRouterRuleMapper viewRouterRuleMapper;

    @Override
    public UserRouterRule findByPrimaryKey(Integer key) {
        if (key == null || key < 1) return null;
        return routerRuleMapper.selectByPrimaryKey(key).orElse(null);
    }

    @Override
    public BootsTableResponse<UserRouterRule> bootsData(BootsTableRequest tableRequest) {
        if (tableRequest == null) return null;
        //分页处理
        PageHelper.offsetPage(tableRequest.getOffset(), tableRequest.getLimit());
        return new BootsTableResponse<>(routerRuleMapper.select(entity -> entity
                .join(UserRouterDynamicSqlSupport.userRouter).on(UserRouterDynamicSqlSupport.id, new EqualTo(routerId))
                .join(UserRuleDynamicSqlSupport.userRule).on(UserRuleDynamicSqlSupport.id, new EqualTo(ruleId))
                .where(delTime, isEqualTo(0))
                .and(routerId, isEqualToWhenPresent(tableRequest.getInteger("routerId")))
                .and(
                        UserRouterDynamicSqlSupport.routerName, isLikeWhenPresent(tableRequest.getSearch()),
                        or(UserRuleDynamicSqlSupport.ruleName, isLikeWhenPresent(tableRequest.getSearch())),
                        or(UserRuleDynamicSqlSupport.ruleType, isLikeWhenPresent(tableRequest.getSearch())),
                        or(UserRuleDynamicSqlSupport.ruleMethod, isLikeWhenPresent(tableRequest.getSearch()))
                )
        ));
    }

    @Override
    public BootsTableResponse<ViewRouterRule> ViewBootsData(BootsTableRequest tableRequest) {
        if (tableRequest == null) return null;
        //分页处理
        PageHelper.offsetPage(tableRequest.getOffset(), tableRequest.getLimit());
        return new BootsTableResponse<>(viewRouterRuleMapper.select(entity -> entity
                .where( ViewRouterRuleDynamicSqlSupport.delTime, isEqualTo(0))
                .and( ViewRouterRuleDynamicSqlSupport.routerId, isEqualToWhenPresent(tableRequest.getInteger("routerId")))
                .and(
                        ViewRouterRuleDynamicSqlSupport.routerName, isLikeWhenPresent(tableRequest.getSearch()),
                        or(ViewRouterRuleDynamicSqlSupport.ruleName, isLikeWhenPresent(tableRequest.getSearch())),
                        or(ViewRouterRuleDynamicSqlSupport.ruleType, isLikeWhenPresent(tableRequest.getSearch())),
                        or(ViewRouterRuleDynamicSqlSupport.ruleMethod, isLikeWhenPresent(tableRequest.getSearch()))
                )
        ));
    }

    @Override
    public int insertSelective(UserRouterRule record) {
        if (record == null) return 0;
        record.prepareEdit();
        return routerRuleMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserRouterRule record) {
        if (record == null) return 0;
        record.prepareEdit();
        return routerRuleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delElementByIdList(List<Integer> idList) {
        if (idList == null || idList.isEmpty()) return 0;
        return routerRuleMapper.update(entity -> entity
                .set(delTime).equalTo((int) (System.currentTimeMillis() / 1000))
                .where(id, isIn(idList))
        );
    }
}

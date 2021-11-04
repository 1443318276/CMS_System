package edu.xww.spring.service;

import com.github.pagehelper.PageHelper;
import edu.xww.db.mapper.UserMasterRuleDynamicSqlSupport;
import edu.xww.db.mapper.UserRouterRuleDynamicSqlSupport;

import edu.xww.db.mapper.UserRuleMapper2;
import edu.xww.db.model.UserMaster;
import edu.xww.db.model.UserRule;
import edu.xww.db.model.UserRule2;
import edu.xww.db.service.AbstractService;
import edu.xww.db.service.UserRuleService;
import org.mybatis.dynamic.sql.select.join.EqualTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;

import java.util.LinkedList;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static edu.xww.db.mapper.UserRuleDynamicSqlSupport.*;

@Service
@Primary
public class UserRuleServiceImpl extends AbstractService implements UserRuleService {

    @Autowired
    private UserRuleMapper2 ruleMapper;

    @Override
    public UserRule findByPrimaryKey(Integer key) {
        if (key == null || key < 1) return null;
        return ruleMapper.selectByPrimaryKey(key).orElse(null);
    }

    @Override
    public BootsTableResponse<UserRule> bootsData(BootsTableRequest tableRequest) {
        if (tableRequest == null) return null;
        //添加查询分页
        PageHelper.offsetPage(tableRequest.getOffset(), tableRequest.getLimit());
        return new BootsTableResponse<>(ruleMapper.select(entity -> {
            //添加花括号是为了实现多行编码
            entity.where(delTime, isEqualTo(0))
                    .and(
                            ruleName, isLikeWhenPresent(tableRequest.getSearch()),
                            or(ruleMethod, isLikeWhenPresent(tableRequest.getSearch())),
                            or(ruleType, isLikeWhenPresent(tableRequest.getSearch())),
                            or(ruleUrl, isLikeWhenPresent(tableRequest.getSearch()))
                    );
            int _pid = (int) tableRequest.getExtras().get("pid");
            if (_pid > 0) {
                entity.where().and(pid, isEqualTo(_pid));
            } else {
                entity.where().and(pid, isNull());
            }
            //添加排序
            super.sortByOrder(tableRequest, entity, userRule);
            return entity;
        }));
    }

    @Override
    public int insertSelective(UserRule record) {
        record.prepareEdit();
        initLevel(record);
        return ruleMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserRule record) {
        record.prepareEdit();
        initLevel(record);
        return ruleMapper.updateByPrimaryKeySelective(record);
    }

    private void initLevel(UserRule record) {
        if (record.getPid() == null) {
            record.setRuleLevel(1);
        } else {
            UserRule parent = findByPrimaryKey(record.getPid());
            if (parent == null) throw new RuntimeException("父级权限不存在");
            record.setRuleLevel(parent.getRuleLevel() + 1);
        }
    }

    @Override
    public int delElementByIdList(List<Integer> idList) {
        if (idList == null || idList.isEmpty()) return 0;
        return ruleMapper.update(entity -> entity
                .set(delTime).equalTo((int) (System.currentTimeMillis() / 1000))
                .where(id, isIn(idList))
        );
    }

    @Override
    public List<UserRule> selectAllParentList() {
        return ruleMapper.select(entity -> entity
                .where(delTime, isEqualTo(0))
                .and(ruleType, isNotEqualTo("API"))
                .and(ruleMethod, isEqualTo("GET"))
                .orderBy(ruleType, ruleMethod, ruleName)
        );
    }

    @Override
    public boolean checkMasterRule(UserMaster master, String method, String uri) {
        if (master == null) return false; //如果用户为空，则不给权限
        if (master.getRouterId() == 1) return true;//超级管理员默认拥有所有权限
        //初始化数据
        final String _method = "GET".equalsIgnoreCase(method) ? "GET" : "POST";
        final String _uri = uri.startsWith("/") ? uri : ("/" + uri);
        //查询指定的权限是否已经定义
        UserRule targetRule = ruleMapper.selectOne(entity -> entity
                .where(delTime, isEqualTo(0))
                .and(ruleMethod, isEqualTo(_method))
                .and(ruleUrl, isEqualTo(_uri),
                        or(ruleUrl, isEqualTo(_uri.replaceFirst("/", "")))
                )
        ).orElse(null);
        if (targetRule == null) return true;//此时权限未在系统中定义，无需对当前权限做限制，，直接开启访问
        //权限查两张表 masterRule routerRule 用于判断用户权限是否存在
        return ruleMapper.selectOne(entity -> entity
                .leftJoin(UserMasterRuleDynamicSqlSupport.userMasterRule).on(UserMasterRuleDynamicSqlSupport.ruleId, new EqualTo(id))
                .leftJoin(UserRouterRuleDynamicSqlSupport.userRouterRule).on(UserRouterRuleDynamicSqlSupport.ruleId, new EqualTo(id))
                .where(delTime, isEqualTo(0))
                .and(
                        UserMasterRuleDynamicSqlSupport.delTime, isEqualTo(0),
                        or(UserMasterRuleDynamicSqlSupport.delTime, isNull())
                )
                .and(
                        UserRouterRuleDynamicSqlSupport.delTime, isEqualTo(0),
                        or(UserRouterRuleDynamicSqlSupport.delTime, isNull())
                )
                .and(
                        UserMasterRuleDynamicSqlSupport.ruleState, isEqualTo("GRANTED"),
                        or(
                                UserRouterRuleDynamicSqlSupport.ruleState, isEqualTo("GRANTED"),
                                and(
                                        UserMasterRuleDynamicSqlSupport.id, isNull()
                                )
                        )
                )
                .and(UserMasterRuleDynamicSqlSupport.masterId, isEqualTo(master.getId()))
                .and(UserRouterRuleDynamicSqlSupport.routerId, isEqualTo(master.getRouterId()))
                .and(id, isEqualTo(targetRule.getId()))
        ).orElse(null) != null;
    }

    @Override
    public List<UserRule2> selectPageListByMaster(UserMaster master) {
        if (master == null) return null;
        if (master.getRouterId() == 1) {
            return ruleMapper.select2(entity -> entity
                    .where(delTime, isEqualTo(0))
                    .and(ruleType, isEqualTo("NAV"))
                    .and(ruleMethod, isEqualTo("GET"))
                    .and(pid, isNull())
            );
        }
        //TODO 查询管理员的页面导航列表
        return null;
    }

    @Override
    public List<UserRule2> selectAllRuleList() {
        return ruleMapper.select2(entity -> entity
                .where(delTime, isEqualTo(0))
                .and(pid, isNull())
        );
    }

    public static List<UserRule> childArrayToList(List<UserRule2> targetList) {
        List<UserRule> ruleList = new LinkedList<>();
        appendChild(targetList, ruleList);
        return ruleList;
    }

    private static void appendChild(List<UserRule2> targetList, List<UserRule> ruleList) {
        if (targetList == null || targetList.isEmpty()) return;
        targetList.forEach(record -> {
            //第一步添加记录
            ruleList.add(record);
            //第二步添加子类
            appendChild(record.getChildList(), ruleList);
        });
    }
}

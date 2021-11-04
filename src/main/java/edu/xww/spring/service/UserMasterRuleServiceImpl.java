package edu.xww.spring.service;

import com.github.pagehelper.PageHelper;
import edu.xww.db.mapper.UserMasterRuleMapper;
import edu.xww.db.model.UserMasterRule;
import edu.xww.db.model.ViewRouterRule;
import edu.xww.db.service.AbstractService;
import edu.xww.db.service.UserMasterRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;


import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static edu.xww.db.mapper.UserMasterRuleDynamicSqlSupport.*;

@Service
@Primary
public class UserMasterRuleServiceImpl extends AbstractService implements UserMasterRuleService {
    @Autowired
    private UserMasterRuleMapper userMasterRuleMapper;

    @Override
    public UserMasterRule findByPrimaryKey(Integer key) {
        return key == null || key < 1 ? null : userMasterRuleMapper.selectByPrimaryKey(key).orElse(null);
    }

    @Override
    public int insertSelective(UserMasterRule record) {
        record.prepareEdit();
        if (record.getMasterId() == null || record.getMasterId() < 1 || record.getRuleId() == null || record.getRuleId() < 1) {
            throw new RuntimeException("管理员为空 或 权限不存在");
        }
        return userMasterRuleMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserMasterRule record) {
        return userMasterRuleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delElementByIdList(List<Integer> idList) {
        if (idList == null || idList.isEmpty()) return 0;
        return userMasterRuleMapper.update(entity -> entity
                .set(delTime).equalTo((int) (System.currentTimeMillis() / 1000))
                .where(id, isIn(idList))
        );
    }

    @Override
    public BootsTableResponse<UserMasterRule> bootsData(BootsTableRequest tableRequest) {
        if (tableRequest == null) return null;
        //添加查询分页
        PageHelper.offsetPage(tableRequest.getOffset(), tableRequest.getLimit());
        return new BootsTableResponse<>(userMasterRuleMapper.select(entity -> {
            entity.where(delTime, isEqualTo(0))
                    .and(masterId, isEqualToWhenPresent(tableRequest.getInteger("routerId")))
                    .and(ruleId, isEqualToWhenPresent(tableRequest.getInteger("ruleId")));
            //添加排序
            super.sortByOrder(tableRequest, entity, userMasterRule);
            return entity;
        }));
    }
    @Override
    public List<UserMasterRule> selectMasterRule() {
        return userMasterRuleMapper.select(entity -> entity.where(delTime, isEqualTo(0)).orderBy(id));
    }

    @Override
    public BootsTableResponse<ViewRouterRule> ViewBootsData(BootsTableRequest tableRequest) {
        return null;
    }
}

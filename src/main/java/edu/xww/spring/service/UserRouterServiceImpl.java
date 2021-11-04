package edu.xww.spring.service;

import com.github.pagehelper.PageHelper;
import edu.xww.db.mapper.UserRouterMapper;
import edu.xww.db.model.UserMaster;
import edu.xww.db.model.UserRouter;
import edu.xww.db.service.AbstractService;
import edu.xww.db.service.UserRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static edu.xww.db.mapper.UserRouterDynamicSqlSupport.*;

@Service
@Primary
public class UserRouterServiceImpl extends AbstractService implements UserRouterService {
    @Autowired
    private UserRouterMapper routerMapper;

    @Override
    public UserRouter findByPrimaryKey(Integer key) {
        if (key == null || key < 1) return null;
        return routerMapper.selectByPrimaryKey(key).orElse(null);
    }

    @Override
    public BootsTableResponse<UserRouter> bootsData(BootsTableRequest tableRequest) {
        if (tableRequest == null) return null;
        //排序
        PageHelper.offsetPage(tableRequest.getOffset(), tableRequest.getLimit());
        return new BootsTableResponse<>(routerMapper.select(entity -> {
            entity.where(delTime, isEqualTo(0))
                    .and(routerName, isLikeWhenPresent(tableRequest.getSearch()));
            //排序
            super.sortByOrder(tableRequest, entity, userRouter);
            return entity;
        }));
    }

    @Override
    public int insertSelective(UserRouter record) {
        if (record == null) return 0;
        record.prepareEdit();
        return routerMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserRouter record) {
        if (record == null || record.getId() == null) return 0;//超级管理员信息禁止修改
        record.prepareEdit();
        return routerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delElementByIdList(List<Integer> idList) {
        if (idList == null) return 0;
        idList.removeIf(entity -> entity <= 1);
        if (idList.isEmpty()) return 0;
        return routerMapper.update(entity -> entity
                .set(delTime).equalTo((int) (System.currentTimeMillis() / 1000))
                .where(id, isIn(idList))
        );
    }

    @Override
    public List<UserRouter> selectRouterList(UserMaster master) {
        if (master == null) return null;
        return routerMapper.select(entity -> {
            entity.where(delTime, isEqualTo(0));
            if (master.getRouterId() > 1) {
                entity.where().and(id, isGreaterThan(master.getRouterId()));
            }
            entity.orderBy(addTime.descending());
            return entity;
        });
    }
}

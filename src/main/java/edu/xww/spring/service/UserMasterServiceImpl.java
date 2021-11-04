package edu.xww.spring.service;

import com.github.pagehelper.PageHelper;
import edu.xww.db.mapper.UserMasterMapper;
import edu.xww.db.model.UserMaster;
import edu.xww.db.service.AbstractService;
import edu.xww.db.service.UserMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static edu.xww.db.mapper.UserMasterDynamicSqlSupport.*;

@Service//声明当前类是用于数据查询的服务类
@Primary//当实现接口MasterService有多个实现类的时候，@Primary用于声明当前类是默认实现类，同一个接口的众多实现类中只有一个实现类可以添加@Primary注解
public class UserMasterServiceImpl extends AbstractService implements UserMasterService {

    //初始化查询接口
    @Autowired
    private UserMasterMapper masterMapper;

    @Override
    public UserMaster findByPrimaryKey(Integer key) {
        if (key == null || key < 1) return null;
        return masterMapper.selectByPrimaryKey(key).orElse(null);
    }

    @Override
    public BootsTableResponse<UserMaster> bootsData(BootsTableRequest tableRequest) {
        if (tableRequest == null) return null;
        //数据分页
        PageHelper.offsetPage(tableRequest.getOffset(), tableRequest.getLimit());
        //数据查询
        return new BootsTableResponse<>(masterMapper.select(entity -> {
            entity.where(delTime, isEqualTo(0))
                    .and(masterName, isLikeWhenPresent(tableRequest.getSearch()))
                    .and(routerId, isEqualToWhenPresent(tableRequest.getInteger("routerId")));
           //添加排序
            super.sortByOrder(tableRequest,entity,userMaster);
            return entity;
        }));
    }

    @Override
    public int insertSelective(UserMaster record) {
        if (record == null) return 0;
        record.prepareEdit();
        record.setId(null);
        return masterMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserMaster record) {
        if (record == null) return 0;
        record.prepareEdit();
        return masterMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delElementByIdList(List<Integer> idList) {
        if (idList == null || idList.isEmpty()) return 0;
        return masterMapper.update(entity -> entity
                .set(delTime).equalTo((int) (System.currentTimeMillis() / 1000))
        );
    }

    @Override
    public UserMaster findMasterByUsername(String userName) {
        if (StringUtils.isEmpty(userName)) return null;
        /*
        return masterMapper.selectOne(new SelectDSLCompleter() {
            @Override
            public Buildable<SelectModel> apply(QueryExpressionDSL<SelectModel> selectModelQueryExpressionDSL) {
                return selectModelQueryExpressionDSL
                        .where(UserMasterDynamicSqlSupport.delTime,isEqualTo(0))
                        .and(UserMasterDynamicSqlSupport.masterUsername,isEqualTo(userName));
            }
        }).orElse(null);
        */
        return masterMapper.selectOne(entity -> entity
                .where(delTime, isEqualTo(0))
                .and(masterUsername, isEqualTo(userName))
        ).orElse(null);
    }
}

package edu.xww.db.mapper;

import static edu.xww.db.mapper.UserRouterDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import edu.xww.db.model.UserRouter;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface UserRouterMapper extends BaseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4997465+08:00", comments="Source Table: user_router")
    BasicColumn[] selectList = BasicColumn.columnList(id, routerName, routerDes, addTime, updateTime, delTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4987512+08:00", comments="Source Table: user_router")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4987512+08:00", comments="Source Table: user_router")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4987512+08:00", comments="Source Table: user_router")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<UserRouter> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4997465+08:00", comments="Source Table: user_router")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserRouterResult")
    Optional<UserRouter> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4997465+08:00", comments="Source Table: user_router")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserRouterResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="router_name", property="routerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="router_des", property="routerDes", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="del_time", property="delTime", jdbcType=JdbcType.INTEGER)
    })
    List<UserRouter> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4997465+08:00", comments="Source Table: user_router")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4997465+08:00", comments="Source Table: user_router")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, userRouter, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4997465+08:00", comments="Source Table: user_router")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, userRouter, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4997465+08:00", comments="Source Table: user_router")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4997465+08:00", comments="Source Table: user_router")
    default int insert(UserRouter record) {
        return MyBatis3Utils.insert(this::insert, record, userRouter, c ->
            c.map(routerName).toProperty("routerName")
            .map(routerDes).toProperty("routerDes")
            .map(addTime).toProperty("addTime")
            .map(updateTime).toProperty("updateTime")
            .map(delTime).toProperty("delTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4997465+08:00", comments="Source Table: user_router")
    default int insertSelective(UserRouter record) {
        return MyBatis3Utils.insert(this::insert, record, userRouter, c ->
            c.map(routerName).toPropertyWhenPresent("routerName", record::getRouterName)
            .map(routerDes).toPropertyWhenPresent("routerDes", record::getRouterDes)
            .map(addTime).toPropertyWhenPresent("addTime", record::getAddTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(delTime).toPropertyWhenPresent("delTime", record::getDelTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5007568+08:00", comments="Source Table: user_router")
    default Optional<UserRouter> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, userRouter, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5007568+08:00", comments="Source Table: user_router")
    default List<UserRouter> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, userRouter, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5007568+08:00", comments="Source Table: user_router")
    default List<UserRouter> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, userRouter, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5007568+08:00", comments="Source Table: user_router")
    default Optional<UserRouter> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5007568+08:00", comments="Source Table: user_router")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, userRouter, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5007568+08:00", comments="Source Table: user_router")
    static UpdateDSL<UpdateModel> updateAllColumns(UserRouter record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(routerName).equalTo(record::getRouterName)
                .set(routerDes).equalTo(record::getRouterDes)
                .set(addTime).equalTo(record::getAddTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(delTime).equalTo(record::getDelTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5007568+08:00", comments="Source Table: user_router")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserRouter record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(routerName).equalToWhenPresent(record::getRouterName)
                .set(routerDes).equalToWhenPresent(record::getRouterDes)
                .set(addTime).equalToWhenPresent(record::getAddTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(delTime).equalToWhenPresent(record::getDelTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5007568+08:00", comments="Source Table: user_router")
    default int updateByPrimaryKey(UserRouter record) {
        return update(c ->
            c.set(routerName).equalTo(record::getRouterName)
            .set(routerDes).equalTo(record::getRouterDes)
            .set(addTime).equalTo(record::getAddTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(delTime).equalTo(record::getDelTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5017411+08:00", comments="Source Table: user_router")
    default int updateByPrimaryKeySelective(UserRouter record) {
        return update(c ->
            c.set(routerName).equalToWhenPresent(record::getRouterName)
            .set(routerDes).equalToWhenPresent(record::getRouterDes)
            .set(addTime).equalToWhenPresent(record::getAddTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(delTime).equalToWhenPresent(record::getDelTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}
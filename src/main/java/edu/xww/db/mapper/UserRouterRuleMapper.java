package edu.xww.db.mapper;

import static edu.xww.db.mapper.UserRouterRuleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import edu.xww.db.model.UserRouterRule;
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
public interface UserRouterRuleMapper extends BaseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5107178+08:00", comments="Source Table: user_router_rule")
    BasicColumn[] selectList = BasicColumn.columnList(id, routerId, ruleId, ruleState, addTime, updateTime, delTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5097198+08:00", comments="Source Table: user_router_rule")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5097198+08:00", comments="Source Table: user_router_rule")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5097198+08:00", comments="Source Table: user_router_rule")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<UserRouterRule> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5097198+08:00", comments="Source Table: user_router_rule")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserRouterRuleResult")
    Optional<UserRouterRule> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5107178+08:00", comments="Source Table: user_router_rule")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserRouterRuleResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="router_id", property="routerId", jdbcType=JdbcType.INTEGER),
        @Result(column="rule_id", property="ruleId", jdbcType=JdbcType.INTEGER),
        @Result(column="rule_state", property="ruleState", jdbcType=JdbcType.CHAR),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="del_time", property="delTime", jdbcType=JdbcType.INTEGER)
    })
    List<UserRouterRule> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5107178+08:00", comments="Source Table: user_router_rule")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5107178+08:00", comments="Source Table: user_router_rule")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, userRouterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5107178+08:00", comments="Source Table: user_router_rule")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, userRouterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5107178+08:00", comments="Source Table: user_router_rule")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5107178+08:00", comments="Source Table: user_router_rule")
    default int insert(UserRouterRule record) {
        return MyBatis3Utils.insert(this::insert, record, userRouterRule, c ->
            c.map(routerId).toProperty("routerId")
            .map(ruleId).toProperty("ruleId")
            .map(ruleState).toProperty("ruleState")
            .map(addTime).toProperty("addTime")
            .map(updateTime).toProperty("updateTime")
            .map(delTime).toProperty("delTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5107178+08:00", comments="Source Table: user_router_rule")
    default int insertSelective(UserRouterRule record) {
        return MyBatis3Utils.insert(this::insert, record, userRouterRule, c ->
            c.map(routerId).toPropertyWhenPresent("routerId", record::getRouterId)
            .map(ruleId).toPropertyWhenPresent("ruleId", record::getRuleId)
            .map(ruleState).toPropertyWhenPresent("ruleState", record::getRuleState)
            .map(addTime).toPropertyWhenPresent("addTime", record::getAddTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(delTime).toPropertyWhenPresent("delTime", record::getDelTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5107178+08:00", comments="Source Table: user_router_rule")
    default Optional<UserRouterRule> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, userRouterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5107178+08:00", comments="Source Table: user_router_rule")
    default List<UserRouterRule> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, userRouterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5127121+08:00", comments="Source Table: user_router_rule")
    default List<UserRouterRule> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, userRouterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5127121+08:00", comments="Source Table: user_router_rule")
    default Optional<UserRouterRule> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5127121+08:00", comments="Source Table: user_router_rule")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, userRouterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5127121+08:00", comments="Source Table: user_router_rule")
    static UpdateDSL<UpdateModel> updateAllColumns(UserRouterRule record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(routerId).equalTo(record::getRouterId)
                .set(ruleId).equalTo(record::getRuleId)
                .set(ruleState).equalTo(record::getRuleState)
                .set(addTime).equalTo(record::getAddTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(delTime).equalTo(record::getDelTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5127121+08:00", comments="Source Table: user_router_rule")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserRouterRule record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(routerId).equalToWhenPresent(record::getRouterId)
                .set(ruleId).equalToWhenPresent(record::getRuleId)
                .set(ruleState).equalToWhenPresent(record::getRuleState)
                .set(addTime).equalToWhenPresent(record::getAddTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(delTime).equalToWhenPresent(record::getDelTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5127121+08:00", comments="Source Table: user_router_rule")
    default int updateByPrimaryKey(UserRouterRule record) {
        return update(c ->
            c.set(routerId).equalTo(record::getRouterId)
            .set(ruleId).equalTo(record::getRuleId)
            .set(ruleState).equalTo(record::getRuleState)
            .set(addTime).equalTo(record::getAddTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(delTime).equalTo(record::getDelTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5127121+08:00", comments="Source Table: user_router_rule")
    default int updateByPrimaryKeySelective(UserRouterRule record) {
        return update(c ->
            c.set(routerId).equalToWhenPresent(record::getRouterId)
            .set(ruleId).equalToWhenPresent(record::getRuleId)
            .set(ruleState).equalToWhenPresent(record::getRuleState)
            .set(addTime).equalToWhenPresent(record::getAddTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(delTime).equalToWhenPresent(record::getDelTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}
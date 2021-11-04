package edu.xww.db.mapper;

import static edu.xww.db.mapper.ViewRouterRuleDynamicSqlSupport.*;

import edu.xww.db.model.ViewRouterRule;
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
public interface ViewRouterRuleMapper extends BaseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5326602+08:00", comments="Source Table: view_router_rule")
    BasicColumn[] selectList = BasicColumn.columnList(id, routerId, ruleId, ruleState, routerName, ruleName, ruleType, ruleMethod, ruleUrl, addTime, updateTime, delTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5316615+08:00", comments="Source Table: view_router_rule")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5316615+08:00", comments="Source Table: view_router_rule")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5316615+08:00", comments="Source Table: view_router_rule")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<ViewRouterRule> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5316615+08:00", comments="Source Table: view_router_rule")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ViewRouterRuleResult")
    Optional<ViewRouterRule> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5316615+08:00", comments="Source Table: view_router_rule")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ViewRouterRuleResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="router_id", property="routerId", jdbcType=JdbcType.INTEGER),
        @Result(column="rule_id", property="ruleId", jdbcType=JdbcType.INTEGER),
        @Result(column="rule_state", property="ruleState", jdbcType=JdbcType.CHAR),
        @Result(column="router_name", property="routerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_name", property="ruleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_type", property="ruleType", jdbcType=JdbcType.CHAR),
        @Result(column="rule_method", property="ruleMethod", jdbcType=JdbcType.CHAR),
        @Result(column="rule_url", property="ruleUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="del_time", property="delTime", jdbcType=JdbcType.INTEGER)
    })
    List<ViewRouterRule> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5316615+08:00", comments="Source Table: view_router_rule")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5316615+08:00", comments="Source Table: view_router_rule")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, viewRouterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5316615+08:00", comments="Source Table: view_router_rule")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, viewRouterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5316615+08:00", comments="Source Table: view_router_rule")
    default int insert(ViewRouterRule record) {
        return MyBatis3Utils.insert(this::insert, record, viewRouterRule, c ->
            c.map(routerId).toProperty("routerId")
            .map(ruleId).toProperty("ruleId")
            .map(ruleState).toProperty("ruleState")
            .map(routerName).toProperty("routerName")
            .map(ruleName).toProperty("ruleName")
            .map(ruleType).toProperty("ruleType")
            .map(ruleMethod).toProperty("ruleMethod")
            .map(ruleUrl).toProperty("ruleUrl")
            .map(addTime).toProperty("addTime")
            .map(updateTime).toProperty("updateTime")
            .map(delTime).toProperty("delTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5316615+08:00", comments="Source Table: view_router_rule")
    default int insertSelective(ViewRouterRule record) {
        return MyBatis3Utils.insert(this::insert, record, viewRouterRule, c ->
            c.map(routerId).toPropertyWhenPresent("routerId", record::getRouterId)
            .map(ruleId).toPropertyWhenPresent("ruleId", record::getRuleId)
            .map(ruleState).toPropertyWhenPresent("ruleState", record::getRuleState)
            .map(routerName).toPropertyWhenPresent("routerName", record::getRouterName)
            .map(ruleName).toPropertyWhenPresent("ruleName", record::getRuleName)
            .map(ruleType).toPropertyWhenPresent("ruleType", record::getRuleType)
            .map(ruleMethod).toPropertyWhenPresent("ruleMethod", record::getRuleMethod)
            .map(ruleUrl).toPropertyWhenPresent("ruleUrl", record::getRuleUrl)
            .map(addTime).toPropertyWhenPresent("addTime", record::getAddTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(delTime).toPropertyWhenPresent("delTime", record::getDelTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5326602+08:00", comments="Source Table: view_router_rule")
    default Optional<ViewRouterRule> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, viewRouterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5326602+08:00", comments="Source Table: view_router_rule")
    default List<ViewRouterRule> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, viewRouterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5326602+08:00", comments="Source Table: view_router_rule")
    default List<ViewRouterRule> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, viewRouterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5326602+08:00", comments="Source Table: view_router_rule")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, viewRouterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5326602+08:00", comments="Source Table: view_router_rule")
    static UpdateDSL<UpdateModel> updateAllColumns(ViewRouterRule record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(routerId).equalTo(record::getRouterId)
                .set(ruleId).equalTo(record::getRuleId)
                .set(ruleState).equalTo(record::getRuleState)
                .set(routerName).equalTo(record::getRouterName)
                .set(ruleName).equalTo(record::getRuleName)
                .set(ruleType).equalTo(record::getRuleType)
                .set(ruleMethod).equalTo(record::getRuleMethod)
                .set(ruleUrl).equalTo(record::getRuleUrl)
                .set(addTime).equalTo(record::getAddTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(delTime).equalTo(record::getDelTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5326602+08:00", comments="Source Table: view_router_rule")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ViewRouterRule record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(routerId).equalToWhenPresent(record::getRouterId)
                .set(ruleId).equalToWhenPresent(record::getRuleId)
                .set(ruleState).equalToWhenPresent(record::getRuleState)
                .set(routerName).equalToWhenPresent(record::getRouterName)
                .set(ruleName).equalToWhenPresent(record::getRuleName)
                .set(ruleType).equalToWhenPresent(record::getRuleType)
                .set(ruleMethod).equalToWhenPresent(record::getRuleMethod)
                .set(ruleUrl).equalToWhenPresent(record::getRuleUrl)
                .set(addTime).equalToWhenPresent(record::getAddTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(delTime).equalToWhenPresent(record::getDelTime);
    }
}
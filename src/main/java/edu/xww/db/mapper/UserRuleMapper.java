package edu.xww.db.mapper;

import static edu.xww.db.mapper.UserRuleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import edu.xww.db.model.UserRule;
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
public interface UserRuleMapper extends BaseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4907702+08:00", comments="Source Table: user_rule")
    BasicColumn[] selectList = BasicColumn.columnList(id, pid, ruleLevel, ruleSort, ruleName, ruleUrl, ruleMethod, ruleType, ruleIcon, ruleDes, addTime, updateTime, delTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4887751+08:00", comments="Source Table: user_rule")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4887751+08:00", comments="Source Table: user_rule")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4887751+08:00", comments="Source Table: user_rule")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<UserRule> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4897867+08:00", comments="Source Table: user_rule")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserRuleResult")
    Optional<UserRule> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4897867+08:00", comments="Source Table: user_rule")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserRuleResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="rule_level", property="ruleLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="rule_sort", property="ruleSort", jdbcType=JdbcType.INTEGER),
        @Result(column="rule_name", property="ruleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_url", property="ruleUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_method", property="ruleMethod", jdbcType=JdbcType.CHAR),
        @Result(column="rule_type", property="ruleType", jdbcType=JdbcType.CHAR),
        @Result(column="rule_icon", property="ruleIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_des", property="ruleDes", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="del_time", property="delTime", jdbcType=JdbcType.INTEGER)
    })
    List<UserRule> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4897867+08:00", comments="Source Table: user_rule")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4897867+08:00", comments="Source Table: user_rule")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, userRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4897867+08:00", comments="Source Table: user_rule")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, userRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4897867+08:00", comments="Source Table: user_rule")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4897867+08:00", comments="Source Table: user_rule")
    default int insert(UserRule record) {
        return MyBatis3Utils.insert(this::insert, record, userRule, c ->
            c.map(pid).toProperty("pid")
            .map(ruleLevel).toProperty("ruleLevel")
            .map(ruleSort).toProperty("ruleSort")
            .map(ruleName).toProperty("ruleName")
            .map(ruleUrl).toProperty("ruleUrl")
            .map(ruleMethod).toProperty("ruleMethod")
            .map(ruleType).toProperty("ruleType")
            .map(ruleIcon).toProperty("ruleIcon")
            .map(ruleDes).toProperty("ruleDes")
            .map(addTime).toProperty("addTime")
            .map(updateTime).toProperty("updateTime")
            .map(delTime).toProperty("delTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4897867+08:00", comments="Source Table: user_rule")
    default int insertSelective(UserRule record) {
        return MyBatis3Utils.insert(this::insert, record, userRule, c ->
            c.map(pid).toPropertyWhenPresent("pid", record::getPid)
            .map(ruleLevel).toPropertyWhenPresent("ruleLevel", record::getRuleLevel)
            .map(ruleSort).toPropertyWhenPresent("ruleSort", record::getRuleSort)
            .map(ruleName).toPropertyWhenPresent("ruleName", record::getRuleName)
            .map(ruleUrl).toPropertyWhenPresent("ruleUrl", record::getRuleUrl)
            .map(ruleMethod).toPropertyWhenPresent("ruleMethod", record::getRuleMethod)
            .map(ruleType).toPropertyWhenPresent("ruleType", record::getRuleType)
            .map(ruleIcon).toPropertyWhenPresent("ruleIcon", record::getRuleIcon)
            .map(ruleDes).toPropertyWhenPresent("ruleDes", record::getRuleDes)
            .map(addTime).toPropertyWhenPresent("addTime", record::getAddTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(delTime).toPropertyWhenPresent("delTime", record::getDelTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4907702+08:00", comments="Source Table: user_rule")
    default Optional<UserRule> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, userRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4907702+08:00", comments="Source Table: user_rule")
    default List<UserRule> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, userRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4907702+08:00", comments="Source Table: user_rule")
    default List<UserRule> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, userRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4907702+08:00", comments="Source Table: user_rule")
    default Optional<UserRule> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4907702+08:00", comments="Source Table: user_rule")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, userRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4907702+08:00", comments="Source Table: user_rule")
    static UpdateDSL<UpdateModel> updateAllColumns(UserRule record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(pid).equalTo(record::getPid)
                .set(ruleLevel).equalTo(record::getRuleLevel)
                .set(ruleSort).equalTo(record::getRuleSort)
                .set(ruleName).equalTo(record::getRuleName)
                .set(ruleUrl).equalTo(record::getRuleUrl)
                .set(ruleMethod).equalTo(record::getRuleMethod)
                .set(ruleType).equalTo(record::getRuleType)
                .set(ruleIcon).equalTo(record::getRuleIcon)
                .set(ruleDes).equalTo(record::getRuleDes)
                .set(addTime).equalTo(record::getAddTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(delTime).equalTo(record::getDelTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4907702+08:00", comments="Source Table: user_rule")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserRule record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(pid).equalToWhenPresent(record::getPid)
                .set(ruleLevel).equalToWhenPresent(record::getRuleLevel)
                .set(ruleSort).equalToWhenPresent(record::getRuleSort)
                .set(ruleName).equalToWhenPresent(record::getRuleName)
                .set(ruleUrl).equalToWhenPresent(record::getRuleUrl)
                .set(ruleMethod).equalToWhenPresent(record::getRuleMethod)
                .set(ruleType).equalToWhenPresent(record::getRuleType)
                .set(ruleIcon).equalToWhenPresent(record::getRuleIcon)
                .set(ruleDes).equalToWhenPresent(record::getRuleDes)
                .set(addTime).equalToWhenPresent(record::getAddTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(delTime).equalToWhenPresent(record::getDelTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4917679+08:00", comments="Source Table: user_rule")
    default int updateByPrimaryKey(UserRule record) {
        return update(c ->
            c.set(pid).equalTo(record::getPid)
            .set(ruleLevel).equalTo(record::getRuleLevel)
            .set(ruleSort).equalTo(record::getRuleSort)
            .set(ruleName).equalTo(record::getRuleName)
            .set(ruleUrl).equalTo(record::getRuleUrl)
            .set(ruleMethod).equalTo(record::getRuleMethod)
            .set(ruleType).equalTo(record::getRuleType)
            .set(ruleIcon).equalTo(record::getRuleIcon)
            .set(ruleDes).equalTo(record::getRuleDes)
            .set(addTime).equalTo(record::getAddTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(delTime).equalTo(record::getDelTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4917679+08:00", comments="Source Table: user_rule")
    default int updateByPrimaryKeySelective(UserRule record) {
        return update(c ->
            c.set(pid).equalToWhenPresent(record::getPid)
            .set(ruleLevel).equalToWhenPresent(record::getRuleLevel)
            .set(ruleSort).equalToWhenPresent(record::getRuleSort)
            .set(ruleName).equalToWhenPresent(record::getRuleName)
            .set(ruleUrl).equalToWhenPresent(record::getRuleUrl)
            .set(ruleMethod).equalToWhenPresent(record::getRuleMethod)
            .set(ruleType).equalToWhenPresent(record::getRuleType)
            .set(ruleIcon).equalToWhenPresent(record::getRuleIcon)
            .set(ruleDes).equalToWhenPresent(record::getRuleDes)
            .set(addTime).equalToWhenPresent(record::getAddTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(delTime).equalToWhenPresent(record::getDelTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}
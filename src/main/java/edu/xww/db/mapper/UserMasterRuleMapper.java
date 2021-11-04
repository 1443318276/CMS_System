package edu.xww.db.mapper;

import static edu.xww.db.mapper.UserMasterRuleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import edu.xww.db.model.UserMasterRule;
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
public interface UserMasterRuleMapper extends BaseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5286695+08:00", comments="Source Table: user_master_rule")
    BasicColumn[] selectList = BasicColumn.columnList(id, masterId, ruleId, ruleState, addTime, updateTime, delTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.526675+08:00", comments="Source Table: user_master_rule")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.526675+08:00", comments="Source Table: user_master_rule")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.526675+08:00", comments="Source Table: user_master_rule")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<UserMasterRule> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5276722+08:00", comments="Source Table: user_master_rule")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserMasterRuleResult")
    Optional<UserMasterRule> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5276722+08:00", comments="Source Table: user_master_rule")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserMasterRuleResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="master_id", property="masterId", jdbcType=JdbcType.INTEGER),
        @Result(column="rule_id", property="ruleId", jdbcType=JdbcType.INTEGER),
        @Result(column="rule_state", property="ruleState", jdbcType=JdbcType.CHAR),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="del_time", property="delTime", jdbcType=JdbcType.INTEGER)
    })
    List<UserMasterRule> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5276722+08:00", comments="Source Table: user_master_rule")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5276722+08:00", comments="Source Table: user_master_rule")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, userMasterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5276722+08:00", comments="Source Table: user_master_rule")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, userMasterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5276722+08:00", comments="Source Table: user_master_rule")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5276722+08:00", comments="Source Table: user_master_rule")
    default int insert(UserMasterRule record) {
        return MyBatis3Utils.insert(this::insert, record, userMasterRule, c ->
            c.map(masterId).toProperty("masterId")
            .map(ruleId).toProperty("ruleId")
            .map(ruleState).toProperty("ruleState")
            .map(addTime).toProperty("addTime")
            .map(updateTime).toProperty("updateTime")
            .map(delTime).toProperty("delTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5276722+08:00", comments="Source Table: user_master_rule")
    default int insertSelective(UserMasterRule record) {
        return MyBatis3Utils.insert(this::insert, record, userMasterRule, c ->
            c.map(masterId).toPropertyWhenPresent("masterId", record::getMasterId)
            .map(ruleId).toPropertyWhenPresent("ruleId", record::getRuleId)
            .map(ruleState).toPropertyWhenPresent("ruleState", record::getRuleState)
            .map(addTime).toPropertyWhenPresent("addTime", record::getAddTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(delTime).toPropertyWhenPresent("delTime", record::getDelTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5286695+08:00", comments="Source Table: user_master_rule")
    default Optional<UserMasterRule> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, userMasterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5286695+08:00", comments="Source Table: user_master_rule")
    default List<UserMasterRule> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, userMasterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5286695+08:00", comments="Source Table: user_master_rule")
    default List<UserMasterRule> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, userMasterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5286695+08:00", comments="Source Table: user_master_rule")
    default Optional<UserMasterRule> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5286695+08:00", comments="Source Table: user_master_rule")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, userMasterRule, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5286695+08:00", comments="Source Table: user_master_rule")
    static UpdateDSL<UpdateModel> updateAllColumns(UserMasterRule record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(masterId).equalTo(record::getMasterId)
                .set(ruleId).equalTo(record::getRuleId)
                .set(ruleState).equalTo(record::getRuleState)
                .set(addTime).equalTo(record::getAddTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(delTime).equalTo(record::getDelTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5286695+08:00", comments="Source Table: user_master_rule")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserMasterRule record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(masterId).equalToWhenPresent(record::getMasterId)
                .set(ruleId).equalToWhenPresent(record::getRuleId)
                .set(ruleState).equalToWhenPresent(record::getRuleState)
                .set(addTime).equalToWhenPresent(record::getAddTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(delTime).equalToWhenPresent(record::getDelTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5286695+08:00", comments="Source Table: user_master_rule")
    default int updateByPrimaryKey(UserMasterRule record) {
        return update(c ->
            c.set(masterId).equalTo(record::getMasterId)
            .set(ruleId).equalTo(record::getRuleId)
            .set(ruleState).equalTo(record::getRuleState)
            .set(addTime).equalTo(record::getAddTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(delTime).equalTo(record::getDelTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5296665+08:00", comments="Source Table: user_master_rule")
    default int updateByPrimaryKeySelective(UserMasterRule record) {
        return update(c ->
            c.set(masterId).equalToWhenPresent(record::getMasterId)
            .set(ruleId).equalToWhenPresent(record::getRuleId)
            .set(ruleState).equalToWhenPresent(record::getRuleState)
            .set(addTime).equalToWhenPresent(record::getAddTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(delTime).equalToWhenPresent(record::getDelTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}
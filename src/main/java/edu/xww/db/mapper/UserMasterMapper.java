package edu.xww.db.mapper;

import static edu.xww.db.mapper.UserMasterDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import edu.xww.db.model.UserMaster;
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
public interface UserMasterMapper extends BaseMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5226853+08:00", comments="Source Table: user_master")
    BasicColumn[] selectList = BasicColumn.columnList(id, routerId, masterName, masterThumb, masterUsername, masterPassword, masterPhone, masterMail, addTime, updateTime, delTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5216885+08:00", comments="Source Table: user_master")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5216885+08:00", comments="Source Table: user_master")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5216885+08:00", comments="Source Table: user_master")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<UserMaster> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5216885+08:00", comments="Source Table: user_master")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserMasterResult")
    Optional<UserMaster> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5216885+08:00", comments="Source Table: user_master")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserMasterResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="router_id", property="routerId", jdbcType=JdbcType.INTEGER),
        @Result(column="master_name", property="masterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="master_thumb", property="masterThumb", jdbcType=JdbcType.VARCHAR),
        @Result(column="master_username", property="masterUsername", jdbcType=JdbcType.VARCHAR),
        @Result(column="master_password", property="masterPassword", jdbcType=JdbcType.CHAR),
        @Result(column="master_phone", property="masterPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="master_mail", property="masterMail", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="del_time", property="delTime", jdbcType=JdbcType.INTEGER)
    })
    List<UserMaster> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5216885+08:00", comments="Source Table: user_master")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5216885+08:00", comments="Source Table: user_master")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, userMaster, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5216885+08:00", comments="Source Table: user_master")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, userMaster, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5216885+08:00", comments="Source Table: user_master")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5216885+08:00", comments="Source Table: user_master")
    default int insert(UserMaster record) {
        return MyBatis3Utils.insert(this::insert, record, userMaster, c ->
            c.map(routerId).toProperty("routerId")
            .map(masterName).toProperty("masterName")
            .map(masterThumb).toProperty("masterThumb")
            .map(masterUsername).toProperty("masterUsername")
            .map(masterPassword).toProperty("masterPassword")
            .map(masterPhone).toProperty("masterPhone")
            .map(masterMail).toProperty("masterMail")
            .map(addTime).toProperty("addTime")
            .map(updateTime).toProperty("updateTime")
            .map(delTime).toProperty("delTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5216885+08:00", comments="Source Table: user_master")
    default int insertSelective(UserMaster record) {
        return MyBatis3Utils.insert(this::insert, record, userMaster, c ->
            c.map(routerId).toPropertyWhenPresent("routerId", record::getRouterId)
            .map(masterName).toPropertyWhenPresent("masterName", record::getMasterName)
            .map(masterThumb).toPropertyWhenPresent("masterThumb", record::getMasterThumb)
            .map(masterUsername).toPropertyWhenPresent("masterUsername", record::getMasterUsername)
            .map(masterPassword).toPropertyWhenPresent("masterPassword", record::getMasterPassword)
            .map(masterPhone).toPropertyWhenPresent("masterPhone", record::getMasterPhone)
            .map(masterMail).toPropertyWhenPresent("masterMail", record::getMasterMail)
            .map(addTime).toPropertyWhenPresent("addTime", record::getAddTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(delTime).toPropertyWhenPresent("delTime", record::getDelTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5226853+08:00", comments="Source Table: user_master")
    default Optional<UserMaster> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, userMaster, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5226853+08:00", comments="Source Table: user_master")
    default List<UserMaster> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, userMaster, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5226853+08:00", comments="Source Table: user_master")
    default List<UserMaster> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, userMaster, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5226853+08:00", comments="Source Table: user_master")
    default Optional<UserMaster> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5226853+08:00", comments="Source Table: user_master")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, userMaster, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5226853+08:00", comments="Source Table: user_master")
    static UpdateDSL<UpdateModel> updateAllColumns(UserMaster record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(routerId).equalTo(record::getRouterId)
                .set(masterName).equalTo(record::getMasterName)
                .set(masterThumb).equalTo(record::getMasterThumb)
                .set(masterUsername).equalTo(record::getMasterUsername)
                .set(masterPassword).equalTo(record::getMasterPassword)
                .set(masterPhone).equalTo(record::getMasterPhone)
                .set(masterMail).equalTo(record::getMasterMail)
                .set(addTime).equalTo(record::getAddTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(delTime).equalTo(record::getDelTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5226853+08:00", comments="Source Table: user_master")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UserMaster record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(routerId).equalToWhenPresent(record::getRouterId)
                .set(masterName).equalToWhenPresent(record::getMasterName)
                .set(masterThumb).equalToWhenPresent(record::getMasterThumb)
                .set(masterUsername).equalToWhenPresent(record::getMasterUsername)
                .set(masterPassword).equalToWhenPresent(record::getMasterPassword)
                .set(masterPhone).equalToWhenPresent(record::getMasterPhone)
                .set(masterMail).equalToWhenPresent(record::getMasterMail)
                .set(addTime).equalToWhenPresent(record::getAddTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(delTime).equalToWhenPresent(record::getDelTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5226853+08:00", comments="Source Table: user_master")
    default int updateByPrimaryKey(UserMaster record) {
        return update(c ->
            c.set(routerId).equalTo(record::getRouterId)
            .set(masterName).equalTo(record::getMasterName)
            .set(masterThumb).equalTo(record::getMasterThumb)
            .set(masterUsername).equalTo(record::getMasterUsername)
            .set(masterPassword).equalTo(record::getMasterPassword)
            .set(masterPhone).equalTo(record::getMasterPhone)
            .set(masterMail).equalTo(record::getMasterMail)
            .set(addTime).equalTo(record::getAddTime)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(delTime).equalTo(record::getDelTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5226853+08:00", comments="Source Table: user_master")
    default int updateByPrimaryKeySelective(UserMaster record) {
        return update(c ->
            c.set(routerId).equalToWhenPresent(record::getRouterId)
            .set(masterName).equalToWhenPresent(record::getMasterName)
            .set(masterThumb).equalToWhenPresent(record::getMasterThumb)
            .set(masterUsername).equalToWhenPresent(record::getMasterUsername)
            .set(masterPassword).equalToWhenPresent(record::getMasterPassword)
            .set(masterPhone).equalToWhenPresent(record::getMasterPhone)
            .set(masterMail).equalToWhenPresent(record::getMasterMail)
            .set(addTime).equalToWhenPresent(record::getAddTime)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(delTime).equalToWhenPresent(record::getDelTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}
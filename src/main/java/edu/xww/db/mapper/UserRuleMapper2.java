package edu.xww.db.mapper;

import edu.xww.db.model.UserRule2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Mapper
public interface UserRuleMapper2 extends UserRuleMapper {

    default List<UserRule2> select2(SelectDSLCompleter completer) {
        List<UserRule2> rule2List = MyBatis3Utils.selectList(this::selectMany2, selectList, UserRuleDynamicSqlSupport.userRule, completer);
        if (rule2List != null) {
            rule2List.forEach(record -> record.setChildList(select2(entity -> entity
                    .where(UserRuleDynamicSqlSupport.delTime, isEqualTo(0))
                    .and(UserRuleDynamicSqlSupport.ruleType, isEqualTo("NAV"))
                    .and(UserRuleDynamicSqlSupport.ruleMethod, isEqualTo("GET"))
                    .and(UserRuleDynamicSqlSupport.pid, isEqualTo(record.getId()))
            )));
        }
        return rule2List;
    }

    default List<UserRule2> selectAll(SelectDSLCompleter completer) {
        List<UserRule2> rule2List = MyBatis3Utils.selectList(this::selectMany2, selectList, UserRuleDynamicSqlSupport.userRule, completer);
        if (rule2List != null) {
            rule2List.forEach(record -> record.setChildList(select2(entity -> entity
                    .where(UserRuleDynamicSqlSupport.delTime, isEqualTo(0))
                    .and(UserRuleDynamicSqlSupport.pid, isEqualTo(record.getId()))
            )));
        }
        return rule2List;
    }


    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "UserRuleResult2", value = {
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
    List<UserRule2> selectMany2(SelectStatementProvider selectStatement);
}

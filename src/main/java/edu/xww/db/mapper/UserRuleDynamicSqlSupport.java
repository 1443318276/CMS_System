package edu.xww.db.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserRuleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4857835+08:00", comments="Source Table: user_rule")
    public static final UserRule userRule = new UserRule();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4867812+08:00", comments="Source field: user_rule.id")
    public static final SqlColumn<Integer> id = userRule.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4867812+08:00", comments="Source field: user_rule.pid")
    public static final SqlColumn<Integer> pid = userRule.pid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4867812+08:00", comments="Source field: user_rule.rule_level")
    public static final SqlColumn<Integer> ruleLevel = userRule.ruleLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4867812+08:00", comments="Source field: user_rule.rule_sort")
    public static final SqlColumn<Integer> ruleSort = userRule.ruleSort;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4877784+08:00", comments="Source field: user_rule.rule_name")
    public static final SqlColumn<String> ruleName = userRule.ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4877784+08:00", comments="Source field: user_rule.rule_url")
    public static final SqlColumn<String> ruleUrl = userRule.ruleUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4877784+08:00", comments="Source field: user_rule.rule_method")
    public static final SqlColumn<String> ruleMethod = userRule.ruleMethod;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4877784+08:00", comments="Source field: user_rule.rule_type")
    public static final SqlColumn<String> ruleType = userRule.ruleType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4877784+08:00", comments="Source field: user_rule.rule_icon")
    public static final SqlColumn<String> ruleIcon = userRule.ruleIcon;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4877784+08:00", comments="Source field: user_rule.rule_des")
    public static final SqlColumn<String> ruleDes = userRule.ruleDes;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4887751+08:00", comments="Source field: user_rule.add_time")
    public static final SqlColumn<Date> addTime = userRule.addTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4887751+08:00", comments="Source field: user_rule.update_time")
    public static final SqlColumn<Date> updateTime = userRule.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4887751+08:00", comments="Source field: user_rule.del_time")
    public static final SqlColumn<Integer> delTime = userRule.delTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4867812+08:00", comments="Source Table: user_rule")
    public static final class UserRule extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> pid = column("pid", JDBCType.INTEGER);

        public final SqlColumn<Integer> ruleLevel = column("rule_level", JDBCType.INTEGER);

        public final SqlColumn<Integer> ruleSort = column("rule_sort", JDBCType.INTEGER);

        public final SqlColumn<String> ruleName = column("rule_name", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleUrl = column("rule_url", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleMethod = column("rule_method", JDBCType.CHAR);

        public final SqlColumn<String> ruleType = column("rule_type", JDBCType.CHAR);

        public final SqlColumn<String> ruleIcon = column("rule_icon", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleDes = column("rule_des", JDBCType.VARCHAR);

        public final SqlColumn<Date> addTime = column("add_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> delTime = column("del_time", JDBCType.INTEGER);

        public UserRule() {
            super("user_rule");
        }
    }
}
package edu.xww.db.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ViewRouterRuleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5306639+08:00", comments="Source Table: view_router_rule")
    public static final ViewRouterRule viewRouterRule = new ViewRouterRule();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5306639+08:00", comments="Source field: view_router_rule.id")
    public static final SqlColumn<Integer> id = viewRouterRule.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5306639+08:00", comments="Source field: view_router_rule.router_id")
    public static final SqlColumn<Integer> routerId = viewRouterRule.routerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5306639+08:00", comments="Source field: view_router_rule.rule_id")
    public static final SqlColumn<Integer> ruleId = viewRouterRule.ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5306639+08:00", comments="Source field: view_router_rule.rule_state")
    public static final SqlColumn<String> ruleState = viewRouterRule.ruleState;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5306639+08:00", comments="Source field: view_router_rule.router_name")
    public static final SqlColumn<String> routerName = viewRouterRule.routerName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5306639+08:00", comments="Source field: view_router_rule.rule_name")
    public static final SqlColumn<String> ruleName = viewRouterRule.ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5306639+08:00", comments="Source field: view_router_rule.rule_type")
    public static final SqlColumn<String> ruleType = viewRouterRule.ruleType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5316615+08:00", comments="Source field: view_router_rule.rule_method")
    public static final SqlColumn<String> ruleMethod = viewRouterRule.ruleMethod;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5316615+08:00", comments="Source field: view_router_rule.rule_url")
    public static final SqlColumn<String> ruleUrl = viewRouterRule.ruleUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5316615+08:00", comments="Source field: view_router_rule.add_time")
    public static final SqlColumn<Date> addTime = viewRouterRule.addTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5316615+08:00", comments="Source field: view_router_rule.update_time")
    public static final SqlColumn<Date> updateTime = viewRouterRule.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5316615+08:00", comments="Source field: view_router_rule.del_time")
    public static final SqlColumn<Integer> delTime = viewRouterRule.delTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5306639+08:00", comments="Source Table: view_router_rule")
    public static final class ViewRouterRule extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> routerId = column("router_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> ruleId = column("rule_id", JDBCType.INTEGER);

        public final SqlColumn<String> ruleState = column("rule_state", JDBCType.CHAR);

        public final SqlColumn<String> routerName = column("router_name", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleName = column("rule_name", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleType = column("rule_type", JDBCType.CHAR);

        public final SqlColumn<String> ruleMethod = column("rule_method", JDBCType.CHAR);

        public final SqlColumn<String> ruleUrl = column("rule_url", JDBCType.VARCHAR);

        public final SqlColumn<Date> addTime = column("add_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> delTime = column("del_time", JDBCType.INTEGER);

        public ViewRouterRule() {
            super("view_router_rule");
        }
    }
}
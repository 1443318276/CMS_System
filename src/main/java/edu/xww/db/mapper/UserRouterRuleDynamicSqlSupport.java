package edu.xww.db.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserRouterRuleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5087223+08:00", comments="Source Table: user_router_rule")
    public static final UserRouterRule userRouterRule = new UserRouterRule();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5087223+08:00", comments="Source field: user_router_rule.id")
    public static final SqlColumn<Integer> id = userRouterRule.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5087223+08:00", comments="Source field: user_router_rule.router_id")
    public static final SqlColumn<Integer> routerId = userRouterRule.routerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5087223+08:00", comments="Source field: user_router_rule.rule_id")
    public static final SqlColumn<Integer> ruleId = userRouterRule.ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5097198+08:00", comments="Source field: user_router_rule.rule_state")
    public static final SqlColumn<String> ruleState = userRouterRule.ruleState;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5097198+08:00", comments="Source field: user_router_rule.add_time")
    public static final SqlColumn<Date> addTime = userRouterRule.addTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5097198+08:00", comments="Source field: user_router_rule.update_time")
    public static final SqlColumn<Date> updateTime = userRouterRule.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5097198+08:00", comments="Source field: user_router_rule.del_time")
    public static final SqlColumn<Integer> delTime = userRouterRule.delTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5087223+08:00", comments="Source Table: user_router_rule")
    public static final class UserRouterRule extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> routerId = column("router_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> ruleId = column("rule_id", JDBCType.INTEGER);

        public final SqlColumn<String> ruleState = column("rule_state", JDBCType.CHAR);

        public final SqlColumn<Date> addTime = column("add_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> delTime = column("del_time", JDBCType.INTEGER);

        public UserRouterRule() {
            super("user_router_rule");
        }
    }
}
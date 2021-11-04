package edu.xww.db.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserMasterRuleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.526675+08:00", comments="Source Table: user_master_rule")
    public static final UserMasterRule userMasterRule = new UserMasterRule();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.526675+08:00", comments="Source field: user_master_rule.id")
    public static final SqlColumn<Integer> id = userMasterRule.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.526675+08:00", comments="Source field: user_master_rule.master_id")
    public static final SqlColumn<Integer> masterId = userMasterRule.masterId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.526675+08:00", comments="Source field: user_master_rule.rule_id")
    public static final SqlColumn<Integer> ruleId = userMasterRule.ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.526675+08:00", comments="Source field: user_master_rule.rule_state")
    public static final SqlColumn<String> ruleState = userMasterRule.ruleState;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.526675+08:00", comments="Source field: user_master_rule.add_time")
    public static final SqlColumn<Date> addTime = userMasterRule.addTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.526675+08:00", comments="Source field: user_master_rule.update_time")
    public static final SqlColumn<Date> updateTime = userMasterRule.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.526675+08:00", comments="Source field: user_master_rule.del_time")
    public static final SqlColumn<Integer> delTime = userMasterRule.delTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.526675+08:00", comments="Source Table: user_master_rule")
    public static final class UserMasterRule extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> masterId = column("master_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> ruleId = column("rule_id", JDBCType.INTEGER);

        public final SqlColumn<String> ruleState = column("rule_state", JDBCType.CHAR);

        public final SqlColumn<Date> addTime = column("add_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> delTime = column("del_time", JDBCType.INTEGER);

        public UserMasterRule() {
            super("user_master_rule");
        }
    }
}
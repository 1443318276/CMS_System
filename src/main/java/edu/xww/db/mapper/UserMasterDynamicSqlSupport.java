package edu.xww.db.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserMasterDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5196931+08:00", comments="Source Table: user_master")
    public static final UserMaster userMaster = new UserMaster();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5196931+08:00", comments="Source field: user_master.id")
    public static final SqlColumn<Integer> id = userMaster.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5196931+08:00", comments="Source field: user_master.router_id")
    public static final SqlColumn<Integer> routerId = userMaster.routerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5206904+08:00", comments="Source field: user_master.master_name")
    public static final SqlColumn<String> masterName = userMaster.masterName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5206904+08:00", comments="Source field: user_master.master_thumb")
    public static final SqlColumn<String> masterThumb = userMaster.masterThumb;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5206904+08:00", comments="Source field: user_master.master_username")
    public static final SqlColumn<String> masterUsername = userMaster.masterUsername;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5206904+08:00", comments="Source field: user_master.master_password")
    public static final SqlColumn<String> masterPassword = userMaster.masterPassword;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5206904+08:00", comments="Source field: user_master.master_phone")
    public static final SqlColumn<String> masterPhone = userMaster.masterPhone;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5206904+08:00", comments="Source field: user_master.master_mail")
    public static final SqlColumn<String> masterMail = userMaster.masterMail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5206904+08:00", comments="Source field: user_master.add_time")
    public static final SqlColumn<Date> addTime = userMaster.addTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5206904+08:00", comments="Source field: user_master.update_time")
    public static final SqlColumn<Date> updateTime = userMaster.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5216885+08:00", comments="Source field: user_master.del_time")
    public static final SqlColumn<Integer> delTime = userMaster.delTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5196931+08:00", comments="Source Table: user_master")
    public static final class UserMaster extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> routerId = column("router_id", JDBCType.INTEGER);

        public final SqlColumn<String> masterName = column("master_name", JDBCType.VARCHAR);

        public final SqlColumn<String> masterThumb = column("master_thumb", JDBCType.VARCHAR);

        public final SqlColumn<String> masterUsername = column("master_username", JDBCType.VARCHAR);

        public final SqlColumn<String> masterPassword = column("master_password", JDBCType.CHAR);

        public final SqlColumn<String> masterPhone = column("master_phone", JDBCType.VARCHAR);

        public final SqlColumn<String> masterMail = column("master_mail", JDBCType.VARCHAR);

        public final SqlColumn<Date> addTime = column("add_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> delTime = column("del_time", JDBCType.INTEGER);

        public UserMaster() {
            super("user_master");
        }
    }
}
package edu.xww.db.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserRouterDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4977519+08:00", comments="Source Table: user_router")
    public static final UserRouter userRouter = new UserRouter();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4977519+08:00", comments="Source field: user_router.id")
    public static final SqlColumn<Integer> id = userRouter.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4977519+08:00", comments="Source field: user_router.router_name")
    public static final SqlColumn<String> routerName = userRouter.routerName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4987512+08:00", comments="Source field: user_router.router_des")
    public static final SqlColumn<String> routerDes = userRouter.routerDes;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4987512+08:00", comments="Source field: user_router.add_time")
    public static final SqlColumn<Date> addTime = userRouter.addTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4987512+08:00", comments="Source field: user_router.update_time")
    public static final SqlColumn<Date> updateTime = userRouter.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4987512+08:00", comments="Source field: user_router.del_time")
    public static final SqlColumn<Integer> delTime = userRouter.delTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4977519+08:00", comments="Source Table: user_router")
    public static final class UserRouter extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> routerName = column("router_name", JDBCType.VARCHAR);

        public final SqlColumn<String> routerDes = column("router_des", JDBCType.VARCHAR);

        public final SqlColumn<Date> addTime = column("add_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> delTime = column("del_time", JDBCType.INTEGER);

        public UserRouter() {
            super("user_router");
        }
    }
}
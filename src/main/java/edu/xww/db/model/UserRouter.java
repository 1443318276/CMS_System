package edu.xww.db.model;

import javax.annotation.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
public class UserRouter extends BaseModel {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4977519+08:00", comments="Source field: user_router.router_name")
    private String routerName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4977519+08:00", comments="Source field: user_router.router_des")
    private String routerDes;
}
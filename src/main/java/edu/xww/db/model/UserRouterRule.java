package edu.xww.db.model;

import javax.annotation.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
public class UserRouterRule extends BaseModel {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5077253+08:00", comments="Source field: user_router_rule.router_id")
    private Integer routerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5077253+08:00", comments="Source field: user_router_rule.rule_id")
    private Integer ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5087223+08:00", comments="Source field: user_router_rule.rule_state")
    private String ruleState;
}
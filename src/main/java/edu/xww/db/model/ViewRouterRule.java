package edu.xww.db.model;

import javax.annotation.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
public class ViewRouterRule extends BaseModel {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5296665+08:00", comments="Source field: view_router_rule.router_id")
    private Integer routerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5296665+08:00", comments="Source field: view_router_rule.rule_id")
    private Integer ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5296665+08:00", comments="Source field: view_router_rule.rule_state")
    private String ruleState;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5296665+08:00", comments="Source field: view_router_rule.router_name")
    private String routerName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5296665+08:00", comments="Source field: view_router_rule.rule_name")
    private String ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5296665+08:00", comments="Source field: view_router_rule.rule_type")
    private String ruleType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5296665+08:00", comments="Source field: view_router_rule.rule_method")
    private String ruleMethod;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5296665+08:00", comments="Source field: view_router_rule.rule_url")
    private String ruleUrl;
}
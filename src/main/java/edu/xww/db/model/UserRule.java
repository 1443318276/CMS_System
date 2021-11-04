package edu.xww.db.model;

import javax.annotation.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
public class UserRule extends BaseModel {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.484786+08:00", comments="Source field: user_rule.pid")
    private Integer pid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.484786+08:00", comments="Source field: user_rule.rule_level")
    private Integer ruleLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.484786+08:00", comments="Source field: user_rule.rule_sort")
    private Integer ruleSort;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.484786+08:00", comments="Source field: user_rule.rule_name")
    private String ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.484786+08:00", comments="Source field: user_rule.rule_url")
    private String ruleUrl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4857835+08:00", comments="Source field: user_rule.rule_method")
    private String ruleMethod;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4857835+08:00", comments="Source field: user_rule.rule_type")
    private String ruleType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4857835+08:00", comments="Source field: user_rule.rule_icon")
    private String ruleIcon;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.4857835+08:00", comments="Source field: user_rule.rule_des")
    private String ruleDes;
}
package edu.xww.db.model;

import javax.annotation.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
public class UserMasterRule extends BaseModel {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5256773+08:00", comments="Source field: user_master_rule.master_id")
    private Integer masterId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5256773+08:00", comments="Source field: user_master_rule.rule_id")
    private Integer ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5256773+08:00", comments="Source field: user_master_rule.rule_state")
    private String ruleState;
}
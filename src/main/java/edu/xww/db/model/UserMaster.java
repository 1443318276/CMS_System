package edu.xww.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.annotation.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
public class UserMaster extends BaseModel {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5176982+08:00", comments="Source field: user_master.router_id")
    private Integer routerId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5186957+08:00", comments="Source field: user_master.master_name")
    private String masterName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5186957+08:00", comments="Source field: user_master.master_thumb")
    private String masterThumb;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5186957+08:00", comments="Source field: user_master.master_username")
    private String masterUsername;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5186957+08:00", comments="Source field: user_master.master_password")
    @JsonIgnore
    private String masterPassword;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5186957+08:00", comments="Source field: user_master.master_phone")
    private String masterPhone;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-11-04T10:36:30.5196931+08:00", comments="Source field: user_master.master_mail")
    private String masterMail;
}
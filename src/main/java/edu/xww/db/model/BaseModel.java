package edu.xww.db.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class BaseModel {
    private Integer id;
    private Date addTime;
    private Date updateTime;
    private Integer delTime;
    private Object extra;

    public boolean isInsert() {
        return id == null || id == 0;
    }

    public void prepareEdit() {
        this.addTime = null;
        this.updateTime = null;
        this.delTime = null;
        if (this.isInsert()) {
            this.id = null;
        }
    }
}

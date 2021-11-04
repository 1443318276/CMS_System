package edu.xww.db.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class UserRule2 extends UserRule {
    private List<UserRule2> childList;
}

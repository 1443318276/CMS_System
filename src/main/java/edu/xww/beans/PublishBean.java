package edu.xww.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class PublishBean extends DeleteBean {
    private String type;
    private String category;
}

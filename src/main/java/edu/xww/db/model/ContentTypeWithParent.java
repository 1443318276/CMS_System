package edu.xww.db.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString(callSuper = true)
public class ContentTypeWithParent extends ContentType {
    private ContentTypeWithParent parentType;
    private List<ContentTypeWithParent> childList;
}

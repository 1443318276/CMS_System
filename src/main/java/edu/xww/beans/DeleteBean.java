package edu.xww.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DeleteBean {
    private List<Integer> idList;
}

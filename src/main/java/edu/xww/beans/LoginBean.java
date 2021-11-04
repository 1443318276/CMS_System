package edu.xww.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginBean {
    private String token;
    private String tdCode;
    private String tdUsername;
    private String tdPassword;
}

package com.token.jwt.sys;

import io.swagger.annotations.ApiModelProperty;

public class LoginForm {
    @ApiModelProperty(required = true, example = "test")
    String username;
    @ApiModelProperty(required = true, example = "123456")
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

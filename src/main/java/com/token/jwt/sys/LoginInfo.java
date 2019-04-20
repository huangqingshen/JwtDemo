package com.token.jwt.sys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoginInfo implements Serializable {
    private String username;
    private String token;
    private Long userId;
    private List<MenuInfo> menus = new ArrayList<>();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<MenuInfo> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuInfo> menus) {
        this.menus = menus;
    }
}


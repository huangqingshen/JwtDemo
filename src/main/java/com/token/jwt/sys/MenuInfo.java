package com.token.jwt.sys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haort
 * @date 17/11/15
 */
public class MenuInfo implements Serializable {
    private boolean selected;
    private Long id;
    private boolean leaf;
    private String name;
    private String path;
    private String icon;
    private List<MenuInfo> menus = new ArrayList<>();

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<MenuInfo> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuInfo> menus) {
        this.menus = menus;
    }
}
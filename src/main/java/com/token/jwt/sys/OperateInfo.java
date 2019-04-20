package com.token.jwt.sys;

public class OperateInfo {
    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OperateInfo{" +
                "id='" + id + '\'' +
                '}';
    }
}

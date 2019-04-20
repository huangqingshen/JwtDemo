package com.token.jwt.sys;

import io.swagger.annotations.ApiModelProperty;

public class SysUserProfile {
    @ApiModelProperty(required = true, example = "原始密码")
    String originalPwd;
    @ApiModelProperty(required = true, example = "新密码")
    String newPwd;
    @ApiModelProperty(required = true, example = "重复密码")
    String rePwd;

    public String getOriginalPwd() {
        return originalPwd;
    }

    public void setOriginalPwd(String originalPwd) {
        this.originalPwd = originalPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getRePwd() {
        return rePwd;
    }

    public void setRePwd(String rePwd) {
        this.rePwd = rePwd;
    }
}


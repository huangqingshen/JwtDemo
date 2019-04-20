package com.token.jwt.service;

import com.token.jwt.sys.LoginForm;
import com.token.jwt.sys.SysUserProfile;
import com.token.jwt.vo.Result;

public interface IAuthService {
    Result login(LoginForm loginForm);

    void init();

    Result updateProfile(SysUserProfile profile);
}

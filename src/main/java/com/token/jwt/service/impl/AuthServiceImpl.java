package com.token.jwt.service.impl;

import com.token.jwt.domain.SysUser;
import com.token.jwt.domain.SysUserRole;
import com.token.jwt.repository.SysUserRepository;
import com.token.jwt.service.IAuthService;
import com.token.jwt.service.ISysMenuService;
import com.token.jwt.sys.LoginForm;
import com.token.jwt.sys.LoginInfo;
import com.token.jwt.sys.MenuInfo;
import com.token.jwt.sys.SysUserProfile;
import com.token.jwt.util.Constants;
import com.token.jwt.util.JwtUtil;
import com.token.jwt.vo.Result;

import com.token.jwt.vo.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class AuthServiceImpl implements IAuthService {
    private final static Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);
    @Autowired
    ISysMenuService menuService;

    @Autowired
    SysUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Result login(LoginForm loginForm) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        LoginInfo loginInfo = new LoginInfo();
        SysUser user = userRepository.findByUsername(username.trim());
        if (user != null) {
            if (passwordEncoder.matches(password.trim(), user.getPassword())) {
                loginInfo.setToken(JwtUtil.generateToken(username));
                loginInfo.setUsername(username);
                loginInfo.setUserId(user.getId());
                Set<SysUserRole> userRoles = user.getRoles();
                if (!CollectionUtils.isEmpty(userRoles)) {
                    List<MenuInfo> menus = menuService.getMenusByRoleName(Constants.ROLE_ADMIN);
                    if (CollectionUtils.isEmpty(menus)) {
                        return Result.failure(ResultCode.DATA_RESULT_NONE);
                    } else {
                        loginInfo.setMenus(menus);

                    }
                }
                return Result.success(loginInfo);
            }
        }
        return Result.failure(ResultCode.SYS_USER_LOGIN_ERROR);
    }

    @Override
    public void init() {
        SysUser user = userRepository.findByUsername(Constants.DEFAULT_ADMIN_NAME);
        if (user == null) {
            user = new SysUser();
            user.setUsername(Constants.DEFAULT_ADMIN_NAME);
            user.setPassword(passwordEncoder.encode("123456"));
            user.setCreateDate(new Date());
            user.setUpdateDate(new Date());
            userRepository.save(user);
        }
    }

    @Override
    public Result updateProfile(SysUserProfile profile) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String username = (String) request.getSession().getAttribute("user");
        if (StringUtils.isEmpty(username)) {
            return Result.failure(ResultCode.DATA_RESULT_NONE);
        }
        SysUser user = userRepository.findByUsername(username);
        if (user == null) {
            return Result.failure(ResultCode.DATA_RESULT_NONE);
        } else {
            if (!passwordEncoder.matches(profile.getOriginalPwd(), user.getPassword())) {
                return Result.failure(ResultCode.ORIGIN_PWD_ERROR);
            }
            user.setPassword(passwordEncoder.encode(profile.getNewPwd()));
            userRepository.save(user);
            return Result.success();
        }
    }
}

package com.token.jwt.controller;

import com.token.jwt.service.IAuthService;
import com.token.jwt.sys.LoginForm;
import com.token.jwt.vo.Result;
import com.token.jwt.vo.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haort
 * @date 2018/2/26
 */
@Api(value="登陆接口",description="登陆接口")
@RestController
public class LoginController {
    @Autowired
    IAuthService authService;

    @ApiOperation(value="登陆（获取token）", notes="登陆（获取token）" ,httpMethod="POST")
    @PostMapping("/login")
    public Result login(@RequestBody LoginForm loginForm) {
        if (StringUtils.isEmpty(loginForm.getUsername()) || StringUtils.isEmpty(loginForm.getPassword())) {
            return Result.failure(ResultCode.PARAM_IS_INVALID);
        }
        // 发送WebSocket消息推送
        //webSocket.sendMessage("男神："+"罗成夫"+"出现了");
        return authService.login(loginForm);
    }
}

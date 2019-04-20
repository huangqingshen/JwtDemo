package com.token.jwt.controller;

import com.token.jwt.sys.OperateInfo;
import com.token.jwt.vo.PageDataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="系统用户管理接口",description="系统用户管理接口")
@RestController
@RequestMapping("/cpi/sysUser")
public class TestController {
    @PostMapping("all")
    @ApiOperation(value="查询嫌疑犯信息", notes="查询嫌疑犯信息" ,httpMethod="POST")
    public String all(@RequestBody OperateInfo operateInfo) {
        return operateInfo.getId();
    }

}

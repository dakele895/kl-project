package com.security.controller;


import com.security.common.WebResponse;
import com.security.entity.UserDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Api(value = "用户管理", description = "用户管理API", position = 100, protocols = "http")
@RestController
public class UserController {

    @ApiOperation(value = "获取用户信息",notes = "获取用户信息")
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public WebResponse user(@AuthenticationPrincipal Principal principal){
        return WebResponse.success(principal.getName());
    }

    @ApiOperation(value = "获取用户信息",notes = "获取用户信息")
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public WebResponse admin(@AuthenticationPrincipal Principal principal){
        return WebResponse.success(principal.getName());
    }

    @ApiOperation(value = "登录",notes = "登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public WebResponse user(@RequestBody UserDO userDO){
        return WebResponse.success(userDO.getUsername());
    }
}

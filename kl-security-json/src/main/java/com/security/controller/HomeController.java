package com.security.controller;


import com.security.common.WebResponse;
import com.security.entity.UserDO;
import com.security.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class HomeController {

    private final UserService userService;


    @ApiOperation(value = "注册",notes = "用户注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public WebResponse doRegister(@RequestBody UserDO userDO){
        // 此处省略校验逻辑
        userService.insert(userDO);
        return WebResponse.success("注册成功");
    }

}

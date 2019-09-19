package com.qupeng.controller;

import com.qupeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    //dubbo框架生成的一个代理对象
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public @ResponseBody Object user(@RequestParam("id") Integer id) {
        //开始调用远程服务
//        userService.updateUserById(id);

        return userService.getUserById(id);
    }
}
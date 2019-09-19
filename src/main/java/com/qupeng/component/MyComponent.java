package com.qupeng.component;

import com.qupeng.model.User;
import com.qupeng.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    //引用远程dubbo服务
    @Reference
    private UserService userService;

    public User test(Integer id) {
        return userService.getUserById(id);
    }
}
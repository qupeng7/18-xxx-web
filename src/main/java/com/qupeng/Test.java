package com.qupeng;

import com.qupeng.component.MyComponent;
import com.qupeng.config.DubboWebConfig;
import com.qupeng.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(DubboWebConfig.class);

        MyComponent myComponent = context.getBean(MyComponent.class);

        User user = myComponent.test(1);

        System.out.println(user);
    }
}
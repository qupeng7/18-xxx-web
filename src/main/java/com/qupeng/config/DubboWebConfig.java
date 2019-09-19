package com.qupeng.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 配置类
 */
@Configuration // == xml
@PropertySource({"xxx-web.properties"}) //读取一下xxx-web.properties配置文件
@ComponentScan(basePackages = {"com.qupeng.component"}) //扫描spring的@Component注解
@EnableDubbo(scanBasePackages = {"com.qupeng.component"}) //扫描dubbo的@Reference注解

@ComponentScan(basePackages = {"com.bjpowernode.controller"})
@EnableWebMvc //开启springmvc，相当于spring.xml中的<mvc:annotation-driven/>
public class DubboWebConfig  implements WebMvcConfigurer {

    /**
     *  <!-- 采用默认的servlet处理静态资源 -->
     * 	<mvc:default-servlet-handler />
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
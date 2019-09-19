package com.qupeng.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // == xml
@PropertySource({"xxx-web.properties"}) //读取一下xxx-web.properties配置文件
@ComponentScan(basePackages = {"com.qupeng.component"}) //扫描spring的@Component注解
@EnableDubbo(scanBasePackages = {"com.qupeng.component"}) //扫描dubbo的@Reference注解
public class DubboWebConfig {

}
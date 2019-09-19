package com.qupeng.init;

import com.qupeng.config.DubboWebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 配置和初始化spring mvc的DispatcherServlet
 */
public class InitWebDispatcher implements WebApplicationInitializer {

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {

        //spring容器
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        context.register(DubboWebConfig.class);

        context.setServletContext(servletContext);

        ServletRegistration.Dynamic dynamic =
                servletContext.addServlet("dispatcher", new DispatcherServlet(context));

        //spring mvc的dispatcherServlet拦截所有
        dynamic.addMapping("/");

        dynamic.setLoadOnStartup(1);
    }
}

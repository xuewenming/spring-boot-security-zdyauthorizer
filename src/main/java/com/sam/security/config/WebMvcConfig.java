package com.sam.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Mr.xuewenming
 * @title: WebMvcConfig
 * @projectName spring-boot-security-zdyauthorizer
 * @description: TODO
 * @date 2019/11/2117:44
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login-home");
        registry.addViewController("/login-home").setViewName("login");
        String
    }
}

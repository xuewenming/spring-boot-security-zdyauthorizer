package com.sam.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Mr.xuewenming
 * @title: WebSecurityConfig
 * @projectName spring-boot-security-zdyauthorizer
 * @description: TODO
 * @date 2019/11/2117:45
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/protal/r/r1").hasAuthority("p1")
                .antMatchers("/protal/r/r2").hasAuthority("p2")
                .antMatchers("/protal/r/r3").access("hasAuthority('P1') and hasAuthority('p2')")
                .antMatchers("/protal/r/**").authenticated()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().permitAll()
                .and()
                // 会话控制，可以设置Session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                // 允许表单登录
                .formLogin()
                // 自定义登录页面
                .loginPage("/login-home")//登录页面
                // 指定登录处理的URL,也就是用户名、密码提交的目的路径
                .loginProcessingUrl("/login")
                // 登录成功后跳转的URL
                .successForwardUrl("/protal/home-success")
                .and()
                .logout()
                // 退出URL
                .logoutUrl("/logout")
                // 退出之后跳转的URL
                .logoutSuccessUrl("/logout?logout")
                // 退出时让Session设置为无效
                .invalidateHttpSession(Boolean.TRUE)
        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

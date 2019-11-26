package com.sam.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.xuewenming
 * @title: LoginController
 * @projectName spring-boot-security-zdyauthorizer
 * @description: TODO
 * @date 2019/11/2117:37
 */
@RestController
@RequestMapping("/protal")
public class LoginController {

    @GetMapping("/home")
    public String login() {
        String name = getName();
        return name + "访问登录";
    }

    @PostMapping("/home-success")
    public String loginSuccess() {
        String name = getName();
        return name + "访问登录";
    }

    @PreAuthorize("hasAuthority('p1')")
    @GetMapping("/r/r1")
    public String r1() {
        String name = getName();
        return name + "访问登录r/r1";
    }

    @GetMapping("/r/r2")
    public String r2() {
        String name = getName();
        return name + "访问登录r/r2";
    }

    /**
     * 获取用户名称
     * @return
     */
    public String getName() {
        String username = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (null == principal) {
            return username = "匿名";
        }
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            String userDetailsUsername = userDetails.getUsername();
            username = userDetailsUsername;
            return username;
        }
        username = principal.toString();
        return username;
    }

}

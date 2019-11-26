package com.sam.security.service;

/**
 * @author Mr.xuewenming
 * @title: ITestService
 * @projectName spring-boot-security-zdyauthorizer
 * @description: TODO
 * @date 2019/11/2215:57
 */
public interface ITestService {
    default String getStr() {
        return "hello";
    }

    void print();

}

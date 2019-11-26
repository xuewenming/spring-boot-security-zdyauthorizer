package com.sam.security.service;

/**
 * @author Mr.xuewenming
 * @title: TestServiceImpl
 * @projectName spring-boot-security-zdyauthorizer
 * @description: TODO
 * @date 2019/11/2215:58
 */
public class TestServiceImpl implements ITestService {


    @Override
    public void print() {
        String str = getStr();
    }
}

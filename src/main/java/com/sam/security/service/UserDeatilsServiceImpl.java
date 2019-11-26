package com.sam.security.service;

import com.sam.security.mappper.TUserMapper;
import com.sam.security.pojo.TUser;
import com.sam.security.pojo.TUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.xuewenming
 * @title: UserDeatilsServiceImpl
 * @projectName spring-boot-security-zdyauthorizer
 * @description: UserDetailsService 实现类
 * @date 2019/11/2119:18
 */
@Service
public class UserDeatilsServiceImpl implements UserDetailsService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        TUserExample example = new TUserExample();
        example.createCriteria().andUsernameEqualTo(s);
        List<TUser> tUsers = tUserMapper.selectByExample(example);
        TUser tUser = tUsers.get(0);
        return User.withUsername(tUser.getUsername()).password(tUser.getPassword()).authorities("p1").build();
    }

    public static void main(String[] args) {
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(hashpw);
    }
}

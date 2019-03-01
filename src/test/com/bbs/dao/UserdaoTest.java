package com.bbs.dao;

import com.bbs.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置spring和junit整合，在junit启动时就会加载spring容器
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserdaoTest {
    @Resource
    private Userdao userdao;

    @Test
    public void getusers() {
        List<User> list =userdao.getusers();
        for(User user:list)
            System.out.println(user);
    }

    @Test
    public void userByid() {
        int userid=10;
        User user=userdao.userByid(userid);
        System.out.println(user);
    }

    @Test
    public void adduser() {
        String username="张三";
        String email="123456789@qq.com";
        int count=userdao.adduser(username,email);
        System.out.println(count);

    }

    @Test
    public void deleteuser() {
        int userid=10;
        int i=userdao.deleteuser(userid);
    }

    @Test
    public void updateuser() {
        String username="木星";
        String email="123456@126.com";
        int userid=9;
        int i=userdao.updateuser(userid,username,email);
    }

    @Test
    public void addpraise() {


    }

    @Test
    public void deletepraise() {
    }
}
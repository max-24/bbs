package com.bbs.service.impl;

import com.bbs.dao.Userdao;
import com.bbs.entity.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserserviceImpl implements UserService {

    @Autowired
    private Userdao userdao;
    //通过注解获得userdao对象实例


    @Override
    public List<User> userlist() {
        return userdao.getusers();
    }

    @Override
    public User userbyId(int userid) {
        return userdao.userByid(userid);
    }

    @Override
    public boolean adduser(String username, String email) {
        int i=userdao.adduser(username,email);
        if(i==1)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateuser(int userid,String username, String email) {
        int i=userdao.updateuser(userid,username,email);
        if(i==1)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteuser(int userid) {
        int i=userdao.deleteuser(userid);
        if(i==1)
            return true;
        else
            return false;
    }
}

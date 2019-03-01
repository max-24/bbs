package com.bbs.service;

import com.bbs.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户信息,在管理员后台需要展示所有用户信息。
     * @return
     */
    public List<User> userlist();

    /**
     * 查询指定用户信息，在用户个人信息页面展示。
     * @param userid
     * @return
     */
    public User userbyId(int userid);

    /**
     * 用户注册时添加用户信息
     * @param username
     * @param email
     * @return
     */
    public boolean adduser(String username,String email);

    /**
     * 用户在个人信息管理界面更改信息
     * @param username
     * @param email
     * @return
     */
    public boolean updateuser(int userid,String username,String email);

    /**
     * 管理员可以对用户信息进行操作
     * @param userid
     * @return
     */
    public boolean deleteuser(int userid);




}

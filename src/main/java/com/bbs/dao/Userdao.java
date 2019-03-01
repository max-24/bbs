package com.bbs.dao;

import com.bbs.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Userdao {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> getusers();

    /**
     * 通过userid查询用户
     * @param userid
     * @return
     */
    public User userByid(int userid);

    /**
     * 添加用户，新添加的用户id自增，时间自动创建，评论、文章、点赞数都默认为0；
     * @param username
     * @param email
     * @return
     */
    public int adduser(@Param("username") String username,@Param("email") String email);

    /**
     * 删除用户信息
     * @param userid
     * @return
     */
    public int deleteuser(int userid);


    /**
     * 更新用户信息
     * @param username
     * @param email
     * @return
     */
    public int updateuser(@Param("userid") int userid,@Param("username") String username,@Param("email") String email);

    /**
     * 用户点赞后，更新点赞数信息
     * @param userid
     *
     * @return
     */
    public int addpraise(int userid);

    /**
     * 用户评论(回复)后，更新评论数信息
     * @param userid

     * @return
     */
    public int addcomment( int userid);

    /**
     * 用户发帖帖子后，更新帖子数信息
     * @param userid

     * @return
     */
    public int addpost(int userid);

    /**
     * 用户删除文章后，更新文章数信息
     * @param userid
     * @return
     */
    public int deletepost(int userid);

    /**
     * 用户删除平论（回复）后，更新评论数信息
     * @param userid
     * @return
     */
    public int deletecomment(int userid);

    /**
     * 用户取消点赞后，更新点赞数信息
     * @param userid
     * @return
     */
    public int deletepraise(int userid);

}

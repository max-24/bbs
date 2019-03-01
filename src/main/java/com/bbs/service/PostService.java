package com.bbs.service;

import com.bbs.entity.Post;

import java.util.List;

public interface PostService {
    /**
     * 进入论坛首页，展示展示所有帖子
     * @return
     */
    public List<Post> postlist();

    /**
     * 比如点击某个帖子链接，返回该帖子详情;可以写个模糊查询的功能，对title进行模糊查询，在搜索里可以查询。
     * @param topicid
     * @return
     */
    public Post postByid(int topicid);

    /**
     * 用户在帖子模块发表帖子，发表成功并更新用户的帖子数信息
     * @param title
     * @param content
     * @param userid
     * @return
     */
    public boolean addpost(String title,String content,int userid);

    /**
     * 用户在帖子管理模块删除帖子，删除成功并更新用户表中用户发表的帖子数信息
     * @param topicid
     * @return
     */
    public boolean deletepost(int topicid);

    /**
     * 用户在帖子管理模块查看已发表的帖子
     * @param userid
     * @return
     */
    public List<Post> postByuser(int userid);

    /**
     * 用户修改帖子
     * @param title
     * @param content
     * @return
     */
    public boolean updatepost(int topicid,String title,String content);


}

package com.bbs.service;

import com.bbs.entity.Comment;

import java.util.List;

public interface CommentService {
    /**
     * 在每个帖子详情下，展示相关的用户评论信息按时间排布。
     * @param topicid
     * @return
     */
    public List<Comment> commentbytopic(int topicid);

    /**
     * 在用户评论模块可以看到自己所有的具体评论信息
     * @param userid
     * @return
     */
    public List<Comment> commentbyuser(int userid);

    /**
     * 用户在某个帖子详情的评论区域对作者评论，并更新用户的评论数信息。
     * @param topicid
     * @param userid
     * @param content
     * @return
     */
    public boolean addcomment(int topicid,int userid,String content);

    /**
     * 用户对帖子评论后也可以删除，并更新用户评论数
     * @param commentid
     * @return
     */
    public boolean deletecomment(int commentid,int userid);



}

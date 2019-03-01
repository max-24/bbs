package com.bbs.service;

import com.bbs.entity.Reply;

import java.util.List;

public interface ReplyService {
    /**
     * 在用户评论模块展示已评论的具体信息
     * @return
     */
    public List<Reply> replyByuser( int userid);

    /**
     * 在某个帖子详情下，在对应的被回复的用户下面按时间顺序，展示其他用户的回复信息
     * @param commentid
     * @return
     */
    public List<Reply> replyBycomment( int commentid);

    /**
     * 对帖子的某一个用户评论进行回复,并更新用户评论数信息
     * @param commentid
     * @param userid
     * @param content
     * @return
     */
    public boolean addreply(int commentid,String content,int useid);

    /**
     * 用户删除自己的回复，并更新用户评论数信息
     * @param replyid
     * @return
     */
    public boolean deletereply(int replyid,int userid);




}

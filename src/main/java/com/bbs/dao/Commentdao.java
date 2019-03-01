package com.bbs.dao;

import com.bbs.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Commentdao {
    /**
     * 通过帖子查询帖子相关的所有评论
     * @param topicid
     * @return
     */
    public List<Comment> commentsBypost(int topicid);

    /**
     * 根据用户查找用户的评论
     * @param userid
     * @return
     */
    public List<Comment> commentByuser(int userid);

    /**
     * 添加评论信息，commenid自增，commentTime自动创建
     * @param topicid
     * @param content
     * @param userid
     * @return
     */
    public int addcomment(@Param("topicid") int topicid,@Param("content") String content,@Param("userid") int userid);

    /**
     * 根据commentid删除评论
     * @param commentid
     * @return
     */
    public int deletecomment(int commentid);
}

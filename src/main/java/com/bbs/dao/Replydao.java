package com.bbs.dao;

import com.bbs.entity.Comment;
import com.bbs.entity.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Replydao {
    /**
     * 通过commentid查询评论相关的所有回复，在前台显示中，只要按照时间的先后顺序把回复打印出就行(还可以将回复与被回复者打印出来）。
     * @param commentid
     * @return
     */
    public List<Reply> replyBycomment(int commentid);

    /**
     * 通过relpyuser查询用户所有的回复。
     * @param replyuser
     * @return
     */
    public List<Reply> replyByuser(int replyuser);

    /**
     * 添加用户回复信息，replyid自增，createTime自动创建
     * @param commentid
     * @param content
     * @param replyuser
     * @return
     */
    public int addreply(@Param("commentid") int commentid,@Param("content") String content,@Param("replyuser") int replyuser);

    /**
     * 删除回复信息
     * @param replyid
     * @return
     */
    public int deletereply(int replyid);
}

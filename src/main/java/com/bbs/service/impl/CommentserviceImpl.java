package com.bbs.service.impl;

import com.bbs.dao.Commentdao;
import com.bbs.dao.Userdao;
import com.bbs.entity.Comment;
import com.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentserviceImpl implements CommentService {
  @Autowired
    private Userdao userdao;

  @Autowired
    private Commentdao commentdao;

    @Override
    public List<Comment> commentbytopic(int topicid) {
        return commentdao.commentsBypost(topicid);
    }

    @Override
    public List<Comment> commentbyuser(int userid) {
        return commentdao.commentByuser(userid);
    }

    @Override
    public boolean addcomment(int topicid, int userid, String content) {
        int i=commentdao.addcomment(topicid, content, userid);
        int j=userdao.addcomment(userid);
        if(i==1&j==1)
            return true;
        else
            return false;
    }

    /*
      用户删除评论后，首先该条评论不在帖子评论区出现，用户的评论数-1，然后该条评论的回复区也不存在。影响在相关用户的个人评论管理
      模块回复仍在，但点击查看详情显示评论已删除。但是回复区的用户的评论数仍不变。
     */
    @Override
    public boolean deletecomment(int commentid,int userid) {
        int i=commentdao.deletecomment(commentid);
        int j=userdao.deletecomment(userid);
        if(i==1&j==1)
            return true;
        else
            return false;
    }
}

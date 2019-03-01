package com.bbs.service.impl;

import com.bbs.dao.Commentdao;
import com.bbs.dao.Replydao;
import com.bbs.dao.Userdao;
import com.bbs.entity.Reply;
import com.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyserviceImpl implements ReplyService {
    @Autowired
    private Replydao replydao;

    @Autowired
    private Userdao userdao;

    @Override
    public List<Reply> replyByuser(int userid) {
        return replydao.replyByuser(userid);
    }

    @Override
    public List<Reply> replyBycomment(int commentid) {
        return replydao.replyBycomment(commentid);
    }

    @Override
    public boolean addreply(int commentid,String content,int userid) {
        int i=replydao.addreply(commentid, content, userid);
        int j=userdao.addcomment(userid);
        if(i==1&j==1)
            return true;
        else
            return false;

    }

    @Override
    public boolean deletereply(int replyid,int userid) {
        int i=replydao.deletereply(replyid);
        int j=userdao.deletecomment(userid);
        if(i==1&j==1)
            return true;
        else
            return false;
    }
}

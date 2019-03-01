package com.bbs.service.impl;

import com.bbs.dao.Postdao;
import com.bbs.dao.Praisedao;
import com.bbs.dao.Userdao;
import com.bbs.entity.Post;
import com.bbs.entity.Praise;
import com.bbs.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PraiseserviceImpl implements PraiseService {
    @Autowired
    private Praisedao praisedao;

    @Autowired
    private Postdao postdao;
    @Autowired
    private Userdao userdao;


    @Override
    public boolean addpraise(int topicid, int userid) {
        int i=praisedao.addpraise(topicid,userid);
        int j=userdao.addpraise(userid);
        if(i==1&j==1)
            return true;
        else
            return false;
    }

    @Override
    public boolean deletepraise(int topidid, int userid) {
        int i=praisedao.deletepraise(topidid, userid);
        int j=userdao.deletepraise(userid);
        if(i==1&j==1)
            return true;
        else
            return false;
    }

    @Override
    public int countpraise(int userid){
        List<Post> postlist=postdao.getpostByuser(userid);
        int count=0;
        for(Post post:postlist)
        {
            count+=praisedao.countbytopic(post.getTopicid());
        }
        return count;
    }
}

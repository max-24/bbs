package com.bbs.service.impl;

import com.bbs.dao.Postdao;
import com.bbs.dao.Userdao;
import com.bbs.entity.Post;
import com.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostserviceImpl implements PostService {

    @Autowired
    private Postdao postdao;

    @Autowired
    private Userdao userdao;

    @Override
    public List<Post> postlist() {
        return postdao.getposts();
    }

    @Override
    public Post postByid(int topicid) {
        return postdao.getpostByid(topicid);
    }

    @Override
    public List<Post> postByuser(int userid) {
        return postdao.getpostByuser(userid);
    }

    @Override
    public boolean addpost(String title, String content, int userid) {
        int i=postdao.addpost(title, content, userid);
        int j=userdao.addpost(userid);
        if(i==1&j==1)
            return true;
        else
            return false;
    }


    @Override
    public boolean updatepost(int topicid,String title, String content) {
        int i=postdao.updatepost(topicid, title, content);
        if(i==1)
            return true;
        else
            return false;
    }

    /*
    用户删除帖子后，首先帖子数-1，在原来的帖子下面相关用户的评论回复信息仍然存在，但是在用户的个人评论管理模块点击查看详情，显示
    帖子已删除。只需要将该帖的外码值置空。
    */
    @Override
    public boolean deletepost(int topicid) {
        int i=postdao.deletepost(topicid);
        int userid=postdao.postbytopic(topicid);
        int j=userdao.deletepost(userid);
        if(i==1&j==1)
            return true;
        else
            return false;
    }



}

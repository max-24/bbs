package com.bbs.entity;

import java.util.Date;

public class Post {
    private int topicid;
    private String title;
    private String content;
    private int userid;
    private Date createTime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLastestTime() {
        return lastestTime;
    }

    public void setLastestTime(Date lastestTime) {
        this.lastestTime = lastestTime;
    }

    public int getUserid() {
        return userid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getTopicid() {
        return topicid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    private Date lastestTime;

    @Override
    public String toString()
    {
        return "topicid:"+topicid+",title:"+title+",content:"+content+",userid:"+userid+"createTime:"+createTime+",lastestTime:"+lastestTime;
    }

    public Post(int topicid,String title,String content)
    {
        this.topicid=topicid;
        this.title=title;
        this.content=content;
    }


}

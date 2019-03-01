package com.bbs.entity;

import java.util.Date;

public class Comment {
    private int commentid;
    private int topicid;
    private int userid;
    private String content;
    private Date createTime;
    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentid=" + commentid +
                ", topicid=" + topicid +
                ", userid=" + userid +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }
}

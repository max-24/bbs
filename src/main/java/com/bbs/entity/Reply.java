package com.bbs.entity;

import java.util.Date;

public class Reply {
    private int replyid;
    private int commentid;
    private int content;
    //回复者id

    private int respondentid;

    public int getReplyid() {
        return replyid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getRespondentid() {
        return respondentid;
    }

    public void setRespondentid(int respondentid) {
        this.respondentid = respondentid;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyid=" + replyid +
                ", commentid=" + commentid +
                ", content=" + content +

                ", respondentid=" + respondentid +
                ", createTime=" + createTime +
                '}';
    }

    public int getContent() {
        return content;
    }



    public void setContent(int content) {
        this.content = content;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public void setReplyid(int replyid) {
        this.replyid = replyid;
    }

    private Date createTime;

}

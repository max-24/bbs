package com.bbs.entity;

public class Praise {
    private int praiseid;
    private int userid;
    private int topicid;

    public int getTopicid() {
        return topicid;
    }

    @Override
    public String toString() {
        return "Praise{" +
                "praiseid=" + praiseid +
                ", userid=" + userid +
                ", topicid=" + topicid +
                '}';
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    public int getPraiseid() {
        return praiseid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setPraiseid(int praiseid) {
        this.praiseid = praiseid;
    }
}

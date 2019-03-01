package com.bbs.entity;

import java.util.Date;

public class User {
    private int userid;
    private String username;
    private String email;

    private Date createTime;
    private int comments;
    private int posts;
    private int praises;

    public int getPosts() {
        return posts;
    }

    public int getPraises() {
        return praises;
    }

    public void setPraises(int praises) {
        this.praises = praises;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public String getUsername() {
        return username;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString()
    {
        return "userid:"+userid+",username:"+username+",email:"+email+",createTime:"+createTime+",posts:"+posts+",comments:"+comments+
                ",praises:"+praises;
    }







}

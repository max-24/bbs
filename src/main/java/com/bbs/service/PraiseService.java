package com.bbs.service;

public interface PraiseService {
    /**
     * 用户在某个帖子下面点赞，并更新用户点赞信息
     * @param topicid
     * @param userid
     * @return
     */
    public boolean addpraise(int topicid,int userid);

    /**
     * 用户取消点赞，更新用户点赞信息
     * @param topidid
     * @param userid
     * @return
     */
    public boolean deletepraise(int topidid,int userid);

    public int countpraise(int userid);
}

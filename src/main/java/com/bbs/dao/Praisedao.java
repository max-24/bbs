package com.bbs.dao;

import org.apache.ibatis.annotations.Param;

public interface Praisedao {
    /**
     * 增加用户点赞信息
     * @param topicid
     * @param userid
     * @return
     */
    public int addpraise(@Param("topicid") int topicid,@Param("userid") int userid);

    /**
     * 用户取消点赞，在实际操作中，考虑到用户点击点赞按钮，每个按钮没有绑定各自的praiseid，点赞或取消点赞可以从对应的topicid和userid，进行添加或删除。
     * @param topicid
     * @param userid
     * @return
     */
    public int deletepraise(@Param("topicid") int topicid,@Param("userid") int userid);

    /**
     * 方便计算用户获得的赞数，计算用户所有的文章获得的赞数
     * @param topicid
     * @return
     */
    public int countbytopic(int topicid);

}

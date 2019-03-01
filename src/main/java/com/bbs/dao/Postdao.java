package com.bbs.dao;

import com.bbs.entity.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Postdao {
    /**
     * 查询全部帖子
     * @return
     */
    public List<Post> getposts();

    /**
     * 通过topic_id查询帖子
     * @param topicid
     * @return
     */
    public Post getpostByid(int topicid);

    /**
     * 通过用户id返回用户所有的帖子
     * @param userid
     * @return
     */
    public List<Post> getpostByuser(int userid);

    /**
     * 添加帖子信息，id自增，时间也自动生成
     * @param title
     * @param content
     * @param userid
     * @return
     */
    public int addpost(@Param("title") String title,@Param("content") String content,@Param("userid") int userid);

    /**
     * 根据topicid修改帖子，只要修改标题，内容，修改时间，时间自动生成
     * @param topicid
     * @param title
     * @param content
     * @return
     */
    public int updatepost(@Param("topicid") int topicid,@Param("title") String title,@Param("content") String content);

    /**
     * 根据topicid删除帖子
     * @param topicid
     * @return
     */
    public int deletepost(int topicid);

    /**
     * 根据帖子id返回用户id，便于service层对user评论数、帖子数、点赞数更新。都在xml中封装
     * @param topicid
     * @return
     */
    public int postbytopic(int topicid);
}

package com.bbs.web;

import com.bbs.dto.Result;
import com.bbs.dto.ComResult;
import com.bbs.entity.Comment;
import com.bbs.entity.Post;
import com.bbs.entity.Reply;
import com.bbs.entity.User;
import com.bbs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@RequestMapping("/") //url:模块/资源/{细分} restful风格url中不要包含对数据操作的名称
public class bbscontroller {
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;
    @Autowired
    private ReplyService replyService;
    @Autowired
    private PraiseService praiseService;

    /*
    给首页传post集合
     */
    @RequestMapping(method = RequestMethod.GET)
    public String main(Model model)
    {
        List<Post> list=postService.postlist();
        /*
        将list集合传递给main.jsp,先建一个main.jsp,跳转到该url(首页)后，遍历list，把帖子展示在指定的区域
         */
        model.addAttribute("main",list);
        return "main";
    }

    @ResponseBody
    @RequestMapping(value = "{userid}/detail/{topicid}",method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable("userid") int userid, @PathVariable("topicid") int topicid, ModelAndView m)
    {
        Map<Comment,List<Reply>> map=new LinkedHashMap<>();
        Post post=postService.postByid(topicid);
        List<Comment> commentList;
        List<Reply> replyList;
        /*
        帖子不存在，返回404.jsp
         */
        if(post==null)
            m.setViewName("404");
        else {
            /*
            将帖子的每个评论和该评论对应每个回复放到map中，使用linkedhashmap可以保证时间顺序的序列
             */
            commentList = commentService.commentbytopic(topicid);
            for (Comment commentlist : commentList) {
                map.put(commentlist, replyService.replyBycomment(commentlist.getCommentid()));
            }

            m.addObject("map", map);
            /*
            detail.jsp为帖子详情界面
             */
            m.setViewName("detail");

        }
        return m;

    }

    @ResponseBody
    @RequestMapping(value = "{userid}/detail/{topicid}",method =RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
    public Result<Object> addcomment(@PathVariable("userid") int userid, @PathVariable("topicid") int topicid,@RequestBody ComResult comResult)
    {

        int user=0;//从session获取当前用户id，这里为了方便就默认为0;

        int state=comResult.getState();//设置3个ajax，url都指向该url映射，如果state是0执行addcomment，如果state是1，执行addreply，如果是2，执行addpraise；

        Result<Object> result;

        if(state==0) {
            int id=comResult.getId();//从ajax，comment获得topicid，reply获得commentid。
            String content=comResult.getMessage();//从ajax获取对应的评论信息
            if(commentService.addcomment(id,user,content))
            {
                result=new Result<>(true,"评论成功");
            }
            else
            {
                result=new Result<>(false,"评论失败");
            }
        }
        else if(state==1)
        {
            int id=comResult.getId();
            String content=comResult.getMessage();//从ajax获取对应的评论信息
            if(replyService.addreply(id,content,user))
            {
                result=new Result<>(true,"回复成功");
            }
            else
            {
                result=new Result<>(false,"回复失败");
            }
        }
        else
        {
            if(praiseService.addpraise(topicid,user))
            {
                result=new Result<>(true,"点赞成功");
            }
            else{
                result=new Result<>(false,"点赞失败");
            }

        }
      return result;
    }

    @ResponseBody
    @RequestMapping(value = "{userid}/detail/{topicid}",method =RequestMethod.DELETE)
    public Result<Object> deletecomment(@PathVariable("userid") int userid, @PathVariable("topicid") int topicid, @RequestBody ComResult comResult)
    {

        int user=0;//从session获取当前用户id，这里为了方便就默认为0;
        int state=comResult.getState();//设置两个ajax，url都指向该url映射，如果state是0执行deletecomment，如果state是1，执行deletereply;state是2，执行deletepraise

        Result<Object> result;

        if(state==0) {
            int currentid=0;//从ajax中获得指定同辈标签id属性，comment获得commentid，reply获得replyid。
            if(commentService.deletecomment(currentid,user))
            {
                result=new Result<>(true,"删除评论成功");
            }
            else
            {
                result=new Result<>(false,"删除评论失败");
            }
        }
        else if(state==1)
        {
            int currentid=0;//从ajax中获得指定同辈标签id属性，comment获得commentid，reply获得replyid。
            if(replyService.deletereply(currentid,user))
            {
                result=new Result<>(true,"删除回复成功");
            }
            else
            {
                result=new Result<>(false,"删除回复失败");
            }
        }
        else{
            if(praiseService.deletepraise(topicid,user))
            {
                result=new Result<>(true,"取消点赞");
            }
            else{
                result=new Result<>(false,"取消失败");
            }
        }
        return result;

    }

    @ResponseBody
    @RequestMapping(value = "/user/{userid}/detail-post",method = RequestMethod.PUT,produces ={"application/json;charset=UTF-8"})
    public Result<Object> updatepost(@PathVariable("userid") int userid,@RequestBody Post post)
    {
        String content=post.getContent();//从ajax获得修改的内容
        String title=post.getTitle();
        int topicid=post.getTopicid(); //从标签属性id获得topicid
        Result<Object> result;

        if(postService.updatepost(topicid,title,content))
        {
            result=new Result<>(true,"修改成功");

        }
        else{
            result=new Result<>(false,"修改失败");
        }
        return result;

    }

    @ResponseBody
    @RequestMapping(value = "/user/{userid/detail-post",method = RequestMethod.DELETE)
    public Result<Object> deletepost(@PathVariable("useid") int userid,Model model,@RequestBody Post post)
    {
        Result<Object> result;
        int topicid=post.getTopicid();
        if (postService.deletepost(topicid)) {
            result = new Result<>(true,  "添加成功");
        } else {
            result = new Result<>(false,  "添加失败");
        }

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/user/{usrid}/detail-post",method = RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
    public Result<Object>  addpost(@PathVariable("userid") int userid, @RequestBody Post post) {
        Result<Object> result;
        String title = post.getTitle();
        String content = post.getContent();
        if (postService.addpost(title, content, userid)) {
            result = new Result<>(true, "添加成功");
        } else {
            result = new Result<>(false, "添加失败");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
    public Result<Object> register(@RequestBody User user)
    {
        String email=user.getEmail();
        String username=user.getUsername();
        Result<Object> result;
        if(userService.adduser(username,email))
        {
            result=new Result<>(true,"注册成功");
        }
        else{
            result=new Result<>(false,"注册失败");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/user/{userid}/user-detail",method = RequestMethod.PUT,produces ={"application/json;charset=UTF-8"})
    public Result<Object> updateuser(@RequestBody User user,@PathVariable("userid") int userid)
    {
        String email=user.getEmail();
        String username=user.getUsername();
        Result<Object> result;
        if(userService.updateuser(userid,username,email))
        {
            result=new Result<>(true,"修改成功");
        }
        else{
            result=new Result<>(false,"修改失败");
        }
        return result;
    }


    @RequestMapping(value = "/user/{userid}/user-post",method = RequestMethod.GET)
    public String postdetail(@PathVariable("userid") int userid,Model model){
        List<Post> postlist=postService.postByuser(userid);
        model.addAttribute("userpost",postlist);
        return "userpost";
        //userpost.jsp是用户帖子模块界面
    }

    @ResponseBody
    @RequestMapping(value = "/user/{userid}/comment-detail",method = RequestMethod.GET)
    public ModelAndView commentdetail(@PathVariable("userid") int userid,ModelAndView m){
        Map<String,Object> map=new HashMap<>();
        map.put("comment",commentService.commentbyuser(userid));
        map.put("reply",replyService.replyByuser(userid));
        map.put("praise",new Integer(praiseService.countpraise(userid)));
        m.addObject("map",map);
        m.setViewName("comdetail");
        return m;
    }

}

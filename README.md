# bbs
ssm+restful bbs后台设计

数据库设计：
CREATE TABLE user (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  user_name varchar(50)  DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  replys int(11) DEFAULT NULL,
  topics int(11) DEFAULT NULL,
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  praises int(11) DEFAULT NULL,
  PRIMARY KEY (user_id)
）

CREATE TABLE post (
  topic_id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  title varchar(100) NOT NULL,
  content` varchar(20140) NOT NULL,
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  lastset_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON         
                                                        UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (topic_id),
  FOREIGN KEY (use_id) REFERENCES user (user_id)
)

CREATE TABLE comment (
  comment_id int(11) NOT NULL AUTO_INCREMENT,
  topic_id int(11) NOT NULL,
  user_id  int(11) NOT NULL,
  comment_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  content varchar(200) NOT NULL,
  PRIMARY KEY (comment_id),
  FOREIGN KEY (use_id)   REFERENCES user (user_id),
  FOREIGN KEY (topic_id) REFERENCES post(topic_id)
)
     
CREATE TABLE reply (
  reply_id int(11) NOT NULL AUTO_INCREMENT,
  comment_id int(11) NOT NULL,
  reply_user int(11) NOT NULL,
  reply_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  content varchar(200) NOT NULL,
  PRIMARY KEY (reply_id),
  FOREIGN KEY (comment_id) REFERENCES comment (comment_id)
  FOREIGN KEY (reply_user) REFERENCES user (user_id)
)

CREATE TABLE praise (
  id int(11) NOT NULL AUTO_INCREMENT,
  topic_id int(11) NOT NULL,
  user_id int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (use_id) REFERENCES user (user_id)
  FOREIGN KEY (topic_id) REFERENCES post (topic_id)
)


设计时在reply（回复表）和comment（评论表）的逻辑花不少时间，考虑的是前台每个帖子详情下面，用户可以对帖主评论，而在每个评论下面其他用户可以对该评论回复，就像贴吧的楼主一样。一般评论或回复都可以删除，在设计时产生了不少外码依赖（可能设计的有点水/汗颜），如果删除帖子或者评论，建立联级删除后原来关联的评论回复记录都没有，但这并不是我们想要的，所以就加了外码的SET NULL依赖，只是把外码设置成null就行。

comment :
 alter table comment add constraint comment_cons
 foreign key(topic_id)
 references post(topic_id)
 on delete set null;
 
 reply:
 alter table reply add constraint reply_cons
 foreign key(comment_id)
 references comment(comment_id)
 on delete set null;

 praise:
 alter table praise add contraint praise_cons
 foreign key(topic_id)
 references post(topic_id)
 on delete set null;



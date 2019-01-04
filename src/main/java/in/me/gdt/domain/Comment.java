package in.me.gdt.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.redis.core.RedisHash;

@RedisHash(value="comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String content;
    private String userMentioned;
    private Date date;
    // fk 
    private Long postid;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }        
    public Date getDate() {
        return date;
    }    
    public void setDate(Date date) {
        this.date = date;
    }
    public String getUserMentioned() {
        return userMentioned;
    }    
    public void setUserMentioned(String userMentioned) {
        this.userMentioned = userMentioned;
    }
    public Long getPostId() {
        return postid;
    }
    public void setPostId(Long postid) {
        this.postid = postid;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
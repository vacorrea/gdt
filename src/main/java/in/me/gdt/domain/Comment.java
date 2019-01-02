package in.me.gdt.domain;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash(value="comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String content;
    // fk 
    private Long postid;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getPostid() {
        return postid;
    }
    public void setPostid(Long postid) {
        this.postid = postid;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
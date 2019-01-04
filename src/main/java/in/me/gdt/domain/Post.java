package in.me.gdt.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@SequenceGenerator(name="postSequence", initialValue=1, allocationSize=100)
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "postSequence")
    private Long id;
    
    @Lob @Column(name="content", length=1024)
    @Type(type = "org.hibernate.type.TextType")
    private String content;

    @Transient private Map<Long, Comment> comments = new HashMap<Long, Comment>();
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setComments(Map<Long, Comment> comments) {
        this.comments = comments;
    }
    public Map<Long, Comment> getComments() {
        return comments;
    }
    public String getContent() {
        return content;
    }    
    public void setContent(String content) {
        this.content = content;
    }
}
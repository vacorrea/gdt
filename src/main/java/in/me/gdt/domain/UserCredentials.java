package in.me.gdt.domain;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("UserCredentials")
public class UserCredentials implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String password;
        
    public Long getId() {
        return id;
    }    
    public void setId(Long id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }    
    public void setPassword(String password) {
        this.password = password;
    }
}
package in.me.gdt.domain;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("UserCredentials")
public class UserCredentials implements Serializable{
    private static final long serialVersionUID = 1L;

    private String password;
    
    public String getPassword() {
        return password;
    }    
    public void setPassword(String password) {
        this.password = password;
    }
}
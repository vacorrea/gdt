package in.me.gdt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserPrincipal {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String userName;
    private String userPasswdHash;
    
    public Integer getUserId() {
        return userId;
    }    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }    
    public String getUserName() {
        return userName;
    }    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * @return the userPasswdHash. This passwd hash will come from redis dynamically as requirement
     */
    public String getUserPasswdHash() {
        //TODO get from redis
        return userPasswdHash;
    }
    /**
     * @param userPasswdHash the userPasswdHash to set. Set on redis
     */
    public void setUserPasswdHash(String userPasswdHash) {
        this.userPasswdHash = userPasswdHash;
    }
}
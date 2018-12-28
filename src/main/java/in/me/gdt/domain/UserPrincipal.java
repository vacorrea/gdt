package in.me.gdt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserPrincipal {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String userName;
    
    private String userPasswdHash;
    
    public Long getId() {
        return id;
    }    
    public void setId(Long id) {
        this.id = id;
    }    
    public String getUserName() {
        return userName;
    }    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * @return the userPasswdHash. This passwd hash will come from redis dynamically as requirement
     * try to use aspect
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
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
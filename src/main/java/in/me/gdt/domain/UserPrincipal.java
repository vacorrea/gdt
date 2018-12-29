package in.me.gdt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="userSequence", initialValue=1, allocationSize=100)
public class UserPrincipal implements Serializable {
    private static final long serialVersionUID = -4290418206362158950L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "userSequence")
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
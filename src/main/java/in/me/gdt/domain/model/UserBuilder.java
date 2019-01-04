package in.me.gdt.domain.model;

import in.me.gdt.domain.model.Role;
import in.me.gdt.domain.model.User;

public class UserBuilder {
    private User userPrincipal;
    private UserBuilder () { this.userPrincipal = new User();   }
    public static UserBuilder newInstance() {  return new UserBuilder();    }
    public User build() { return this.userPrincipal; }

    public UserBuilder userId(Long id) { 
        this.userPrincipal.setId(id);;
        return this;
    }
    public UserBuilder userName(String userName) { 
        this.userPrincipal.setUsername(userName);
        return this;
    }
    public UserBuilder userPasswdHash(String userPasswdHash) { 
        this.userPrincipal.setPassword(userPasswdHash);
        return this;
    }
    public UserBuilder userRole(Role role) {
        this.userPrincipal.getRoles().add(role);
        return this;
    }
}
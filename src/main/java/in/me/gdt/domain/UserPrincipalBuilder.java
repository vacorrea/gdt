package in.me.gdt.domain;

public class UserPrincipalBuilder {
    private UserPrincipal userPrincipal;
    private UserPrincipalBuilder () { this.userPrincipal = new UserPrincipal();   }
    public static UserPrincipalBuilder newInstance() {  return new UserPrincipalBuilder();    }
    public UserPrincipal build() { return this.userPrincipal; }

    public UserPrincipalBuilder userId(Long id) { 
        this.userPrincipal.setId(id);;
        return this;
    }
    public UserPrincipalBuilder userName(String userName) { 
        this.userPrincipal.setUserName(userName);
        return this;
    }
    public UserPrincipalBuilder userPasswdHash(String userPasswdHash) { 
        this.userPrincipal.setUserPasswdHash(userPasswdHash);
        return this;
    }
}
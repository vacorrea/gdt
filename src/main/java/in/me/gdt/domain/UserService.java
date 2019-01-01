package in.me.gdt.domain;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService extends JpaRepository<UserPrincipal, Long> {
    UserPrincipal findByUserName(String name);
}
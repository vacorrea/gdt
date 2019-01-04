package in.me.gdt.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import in.me.gdt.domain.model.User;

public interface UserService extends JpaRepository<User, Long> {
    User findByUserName(String name);
}
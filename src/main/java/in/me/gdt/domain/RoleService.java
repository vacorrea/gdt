package in.me.gdt.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import in.me.gdt.domain.model.Role;

public interface RoleService extends JpaRepository<Role, Long>{
    
}
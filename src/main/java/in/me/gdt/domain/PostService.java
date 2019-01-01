
package in.me.gdt.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostService extends JpaRepository<Post, Long>{
    
}
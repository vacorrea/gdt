
package in.me.gdt.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import in.me.gdt.domain.model.Post;

public interface PostService extends JpaRepository<Post, Long>{
    
}
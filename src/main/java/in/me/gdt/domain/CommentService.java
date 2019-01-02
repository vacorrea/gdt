package in.me.gdt.domain;

import java.util.Map;

import org.springframework.data.repository.CrudRepository;


public interface CommentService extends CrudRepository<Comment, Long> {
    Map<Long, Comment> findByPostId(Long id);
}
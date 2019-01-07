package in.me.gdt.domain;

import java.util.Map;

import org.springframework.data.repository.CrudRepository;

import in.me.gdt.domain.model.Comment;


public interface CommentService extends CrudRepository<Comment, Long> {
    Map<Long, Comment> findByPostid(Long postid);
}
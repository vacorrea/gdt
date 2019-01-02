package in.me.gdt.domain;

import org.springframework.data.repository.CrudRepository;

public interface CommentService extends CrudRepository<Comment, Long> {

}
package in.me.gdt.domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.me.gdt.domain.Post;
import in.me.gdt.domain.PostService;

@Service
public class ActionService {
    @Autowired private PostService postService;
    @Autowired private CommentService commentService;

    public Post getPostById(Long id) throws IllegalArgumentException {
        Optional<Post> optPost = postService.findById(id); 
        Post post = null;
        if(!optPost.isPresent()) 
            throw new IllegalArgumentException();
        post = optPost.get();        
        post.setComments(commentService.findByPostId(post.getId()));          
        return post;
    }
    public List<Post> getAllPosts() {
        List<Post> posts = postService.findAll();
        return posts;
    }
    public void insertPost(Post post) {
        postService.save(post);
        for(Map.Entry<Long, Comment> entry : post.getComments().entrySet())
            commentService.save(entry.getValue());        
    }
}
package in.me.gdt.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.me.gdt.domain.model.Comment;
import in.me.gdt.domain.model.Post;

@Service
public class ActionService {
    @Autowired private PostService postService;
    @Autowired private CommentService commentService;
    @Autowired private UserService userService;


    public Post getPostById(Long id) throws IllegalArgumentException {
        Optional<Post> optPost = postService.findById(id);         
        if(!optPost.isPresent()) 
            throw new IllegalArgumentException();
        Post post = optPost.get();                      
        post.setComments(parseResult(commentService.findAll()));          
        return post;
    }
    private Map<Long, Comment> parseResult(Iterable<Comment> iterable) {
        Map<Long, Comment> map = new HashMap<Long, Comment>();
        Iterator<Comment> it = iterable.iterator();
        while(it.hasNext()) {
            Comment comment = it.next();            
            map.put(comment.getId(), comment);
        }
        return map;
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
package in.me.gdt;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.me.gdt.domain.CommentService;
import in.me.gdt.domain.Post;
import in.me.gdt.domain.PostService;
import in.me.gdt.domain.UserPrincipal;
import in.me.gdt.domain.UserService;


@RestController
@RequestMapping(value="/")
public class RestService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());    
    @Autowired private UserService userService;    
    @Autowired private PostService postService;
    @Autowired private CommentService commentService;

    // TODO BCryptPasswordEncoder passwordEncoder; 
    
    @RequestMapping(method=RequestMethod.GET, value="/action")
    public ResponseEntity<String> actionRequest(@RequestParam(value="id", defaultValue="1") Long postid) {
        Optional<Post> optPost = postService.findById(postid); 
        Post post = null;
        logger.info(postid.toString());
        if(optPost.isPresent())  
           post = optPost.get();        
        //post.setComments(commentService.findByPostId(post.getId()));          
        return ResponseEntity.status(HttpStatus.OK).body(postid.toString());
    }

    @RequestMapping(method=RequestMethod.GET, value="/login")
    public ResponseEntity<String> loginRequest(@RequestParam(value="userName", defaultValue="login") String userName) {
        logger.info(userName);
        return ResponseEntity.status(HttpStatus.OK).body(userName);
    }
    @RequestMapping(method=RequestMethod.GET, value="/load")
    public UserPrincipal userPrincipalRequest(@RequestParam(value="id") Long id) {
        Optional<UserPrincipal> oup = userService.findById(id);                
        return oup.get();
    }
    
}
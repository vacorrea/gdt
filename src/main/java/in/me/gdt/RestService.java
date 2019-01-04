package in.me.gdt;

import java.util.Date;
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
import in.me.gdt.domain.ActionService;
import in.me.gdt.domain.Post;
import in.me.gdt.domain.UserService;
import in.me.gdt.domain.model.User;


@RestController
@RequestMapping(value="/api")
public class RestService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());    
    @Autowired private UserService userService;    
    @Autowired private ActionService actionService;    

    // TODO BCryptPasswordEncoder passwordEncoder; 
    
    @RequestMapping(method=RequestMethod.GET, value="/action")
    public ResponseEntity<String> actionRequest(@RequestParam(value="id", defaultValue="1") Long postid) {       
        logger.info(postid.toString());        
        Post post = actionService.getPostById(postid);
        return ResponseEntity.status(HttpStatus.OK).body(post.toString());
    }
    @RequestMapping(method=RequestMethod.GET, value="/action/search")
    public ResponseEntity<String> SearchRequest(@RequestParam(value="id", defaultValue="1", required=true) Long postId,
         @RequestParam(value="userMention", required=false) String userMentioned, @RequestParam(value="date") Date date) {       
        logger.info(postId.toString());
        Post post = actionService.getPostById(postId);
        return ResponseEntity.status(HttpStatus.OK).body(post.toString());
    }

    @RequestMapping(method=RequestMethod.GET, value="/login")
    public ResponseEntity<String> loginRequest(@RequestParam(value="userName", defaultValue="login") String userName) {
        logger.info(userName);
        return ResponseEntity.status(HttpStatus.OK).body(userName);
    }
    @RequestMapping(method=RequestMethod.GET, value="/load")
    public ResponseEntity<User> userPrincipalRequest(@RequestParam(value="id") Long id) {
        logger.info(id.toString());
        Optional<User> oup = userService.findById(id);              
        User up = oup.get();
        actionService.getPostById(1L);
        actionService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK).body(up);
    }
    
}
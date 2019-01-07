package in.me.gdt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

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
import in.me.gdt.domain.UserService;
import in.me.gdt.domain.model.Comment;
import in.me.gdt.domain.model.Post;
import in.me.gdt.domain.model.User;


@RestController
@RequestMapping(value="/api")
public class RestService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());    
    @Autowired private UserService userService;    
    @Autowired private ActionService actionService;    
    
    @RequestMapping(method=RequestMethod.GET, value="/action")
    public ResponseEntity<String> actionRequest(@RequestParam(value="id", defaultValue="1") Long postid) {            
        Post post = actionService.getPostById(postid);
        for(Entry<Long, Comment> entry : post.getComments().entrySet())
            logger.info(entry.getKey() + " - " + entry.getValue());
        return ResponseEntity.status(HttpStatus.OK).body(post.toString());
    }
    @RequestMapping(method=RequestMethod.GET, value="/action/search")
    public ResponseEntity<String> SearchRequest(@RequestParam(value="id", defaultValue="1", required=true) Long postId, 
         @RequestParam(value="userMention", required=false) String userMentioned, @RequestParam(value="date") Date date) {              
        Map<Object, Object> map = new HashMap<Object, Object>();        
        map.put(Long.class, postId); 
        if(userMentioned != null) 
            map.put(String.class, userMentioned); 
        if(date != null)
            map.put(Date.class, date);
        Post post = actionService.getPostById(postId); 
        return ResponseEntity.status(HttpStatus.OK).body(post.toString());
    }
    /* what: high load request for test purpose */
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
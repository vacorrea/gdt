
package in.me.gdt;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import in.me.gdt.domain.Comment;
import in.me.gdt.domain.CommentService;
import redis.embedded.RedisServer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {    
    
    private RedisServer redisServer;
    @Value("${spring.redis.port}")
    private int port;

    @Autowired private CommentService commentService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());    

    @Test public void lookupTest() {
        Assert.assertTrue(redisServer.isActive());
        /* Comment comment = new Comment(); 
        comment.setContent("lorem ipsum lorem lorem. Lorem ipsum lorem lorem lorem max");
        comment.setDate(new Date()); comment.setUserMentioned("max");
        comment.setPostId(1l);
        commentService.save(comment);
        Optional<Comment> opt =  commentService.findById(1l);
        Assert.assertTrue(opt.isPresent());
        Assert.assertEquals("max", opt.get().getUserMentioned());
        logger.info(opt.get().getContent());
        */
    }    
    
    @Before
    public void startServer() throws IOException {        
        this.redisServer = new RedisServer(port);
        redisServer.start();
    }    
    @After
    public void stopServer() {
        redisServer.stop();
    }    
}
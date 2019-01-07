
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
import in.me.gdt.domain.CommentService;
import in.me.gdt.domain.model.Comment;
import net.bytebuddy.utility.RandomString;
import redis.embedded.RedisServer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {    
    
    private RedisServer redisServer;
    @Value("${spring.redis.port}")
    private int port;

    @Autowired 
    private CommentService commentService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());    

    @Test public void lookupTest() {
        Assert.assertTrue(redisServer.isActive());
        Comment comment = new Comment(); 
        comment.setContent(createRandomLoremIpsum(RandomString.make(10)));
        comment.setDate(new Date()); comment.setUserMentioned("anne hataway");
        comment.setPostId(1l);
        commentService.save(comment);
        Optional<Comment> opt =  commentService.findById(1l);
        Assert.assertTrue(opt.isPresent());
        Assert.assertEquals("anne hataway", opt.get().getUserMentioned());
        logger.info(opt.get().getContent());
    }    
    private String createRandomLoremIpsum(String string) {
        return string + RandomString.make(20) + string + RandomString.make(10);
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
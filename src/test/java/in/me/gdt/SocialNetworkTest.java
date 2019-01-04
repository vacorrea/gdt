package in.me.gdt;

import java.io.IOException;
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
import redis.embedded.RedisServer;
import org.springframework.test.context.junit4.SpringRunner;

import in.me.gdt.domain.ActionService;
import in.me.gdt.domain.Comment;
import in.me.gdt.domain.CommentService;
import in.me.gdt.domain.Post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialNetworkTest {

    private RedisServer redisServer;
    @Value("${spring.redis.port}")
    private int port;
    @Autowired private CommentService commentService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired private ActionService actionService;

    @Test public void insertContentTest() throws IllegalArgumentException {
        Comment comment = new Comment();
        comment.setPostId(1L); comment.setContent(getLoremIpsum());
        commentService.save(comment);       
        logger.info("insertContentTest");
        Post post = actionService.getPostById(1L);
        //logger.info(post.getContent()); logger.info(post.getComments().get(1L).toString());
        //Assert.assertNotNull(post);
    }

    private String getLoremIpsum() {
        return "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...";
    }
    private String getLoremIpsum(String b) {
        return "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. ";
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
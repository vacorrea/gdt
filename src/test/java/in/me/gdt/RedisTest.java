
package in.me.gdt;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import in.me.gdt.domain.UserCredentialService;
import redis.embedded.RedisServer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired private UserCredentialService userCredentialService;
    
    private RedisServer redisServer;
    @Value("${spring.redis.port}")
    private int port;

    @Test public void lookupTest() {
        Assert.assertTrue(redisServer.isActive());
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

package in.me.gdt;

import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import in.me.gdt.domain.CommentService;
import in.me.gdt.domain.model.Comment;
import net.bytebuddy.utility.RandomString;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {    
    

    @Autowired 
    private CommentService commentService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());    
    
    @Test
    public void createContentTest() {
        Comment comment = new Comment(); 
        comment.setContent(createRandomLoremIpsum(RandomString.make(10)));
        comment.setDate(new Date()); comment.setUserMentioned("anne hataway");
        comment.setPostId(11l);
        commentService.save(comment);
    }
    
    private String createRandomLoremIpsum(String string) {
        return string + "lorem ipsum lorem lorem ipsum " +
          "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque " +
           RandomString.make(20) + string + RandomString.make(10);
    }
    
}
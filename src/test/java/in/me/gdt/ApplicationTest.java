package in.me.gdt;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import in.me.gdt.domain.UserService;
import in.me.gdt.domain.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@Autowired private UserService userService;
	private Logger logger = Logger.getLogger(ApplicationTest.class.getName());
    
    @Test public void databaseTest() {
        logger.info("databaseTest \n\n");
        List<User> upList = userService.findAll();
        for (User var : upList) 
            logger.info(var.toString());
    }
    
	@Test public void userCreationTest() {
        //userService.save(UserPrincipalBuilder.newInstance().userName("max").userPasswdHash("hxcsao1283").build());
        //UserPrincipal up = userService.findByUserName("max");
        //Assert.assertNotNull(up);
        //Assert.assertEquals("max", up.getUserName());
		
		//Optional<User> b = userService.findById(1L);
		//Assert.assertTrue(b.isPresent());
		//logger.info(b.get().getUsername());
	}
	@Test
	public void whenUserDoesntExistsTest() {
		Optional<User> oup = userService.findById(9999999L);
		Assert.assertFalse(oup.isPresent());
	}
	
}


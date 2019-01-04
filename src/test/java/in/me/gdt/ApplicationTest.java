package in.me.gdt;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import in.me.gdt.domain.RoleService;
import in.me.gdt.domain.UserService;
import in.me.gdt.domain.model.Role;
import in.me.gdt.domain.model.User;
import in.me.gdt.domain.model.UserBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	private Logger logger = Logger.getLogger(ApplicationTest.class.getName());
	@Autowired private UserService userService;		
	@Mock private BCryptPasswordEncoder mockBCryptPasswordEncoder;
	
    @Test public void databaseTest() {
        logger.info("databaseTest \n\n");
        List<User> upList = userService.findAll();
        for (User var : upList) 
            logger.info(var.toString());
    }
    @Test
    public void testFindUserByEmail() {		
		User user = userService.findByUserName("jonny depp");		        
        Assert.assertEquals("jonny@depp.com", user.getPassword());
    }

    @Test
    public void userCreationTest() {
        User user = UserBuilder.newInstance().userId(1L).userName("hulk banner")
				.userPasswdHash("hulk@banner.com").userRole(new Role(1L, "USER")).build();                
        user = userService.save(user);        
        Assert.assertTrue(user.getPassword().equals("hulk@banner.com"));
    }
	//@Test public void userCreationTest() {
        //userService.save(UserPrincipalBuilder.newInstance().userName("max").userPasswdHash("hxcsao1283").build());
        //UserPrincipal up = userService.findByUserName("max");
        //Assert.assertNotNull(up);
        //Assert.assertEquals("max", up.getUserName());
		
		//Optional<User> b = userService.findById(1L);
		//Assert.assertTrue(b.isPresent());
		//logger.info(b.get().getUsername());
	//}
	@Test
	public void whenUserDoesntExistsTest() {
		Optional<User> oup = userService.findById(9999999L);
		Assert.assertFalse(oup.isPresent());
	}
	
}


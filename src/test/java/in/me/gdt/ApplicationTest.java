package in.me.gdt;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import in.me.gdt.domain.RoleService;
import in.me.gdt.domain.UserService;
import in.me.gdt.domain.model.Role;
import in.me.gdt.domain.model.User;
import in.me.gdt.domain.model.UserBuilder;
import in.me.gdt.infra.BCryptPasswordEncoder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	private Logger logger = Logger.getLogger(ApplicationTest.class.getName());
	@Autowired private UserService userService;		
	
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
    public void searchByPassTest() {
        User user = UserBuilder.newInstance().userName("user"+RandomString.make(10))
				.userPasswdHash(createCryptPass()).userRole(new Role(1L, "USER")).build();                
        user = userService.save(user);        
        Assert.assertTrue(user.getPassword().equals(user.getPassword()));
    }
	@Test public void userCreationTest() {
        User user =  UserBuilder.newInstance().userName("user" + RandomString.make(10)).userPasswdHash(createCryptPass())
                    .userRole(new Role(11L, "ADMIN")).build();
        user = userService.save(user);
        User up = userService.findByUserName(user.getUsername());        
        Assert.assertNotNull(up);	
		Optional<User> b = userService.findById(user.getId());
		Assert.assertTrue(b.isPresent());
		logger.info(b.get().getUsername());
    }
    private String createCryptPass() {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        return bcrypt.encode("pass"+RandomString.make(10));
    }
	@Test
	public void whenUserDoesntExistsTest() {
		Optional<User> oup = userService.findById(9999999L);
		Assert.assertFalse(oup.isPresent());
	}
	
}


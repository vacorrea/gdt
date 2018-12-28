package in.me.gdt;

import java.util.Optional;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import in.me.gdt.domain.UserPrincipal;
import in.me.gdt.domain.UserPrincipalBuilder;
import in.me.gdt.domain.UserService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired private UserService userService;
	private Logger logger = Logger.getLogger(GdtApplicationTests.class.getName());
	
	@Test
	public void givenUserCreationTest() {
		userService.save(UserPrincipalBuilder.newInstance().userName("jax").userPasswdHash("hxcsao1283").build());
		UserPrincipal up = userService.findByUserName("jax");
		Optional<UserPrincipal> b = userService.findById(1L);
		Assert.assertTrue(b.isPresent());
		Assert.assertNotNull(up);	
		logger.info(b.get().getUserName());
	}
	@Test
	public void givenNullUserErrorTest() {
		Optional<UserPrincipal> oup = userService.findById(9999999L);
		Assert.assertFalse(oup.isPresent());
	}
	
}


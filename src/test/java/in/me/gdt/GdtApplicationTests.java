package in.me.gdt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import in.me.gdt.domain.UserService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class GdtApplicationTests {

	@Autowired private UserService userService;
	@Autowired private RestService RestService;
	
	@Test
	public void contextLoads() {
		userService.repositoryActionTest();
	}
	
}


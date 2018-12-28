package in.me.gdt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GdtApplication {
	
	@Autowired private RestService restService;

	public static void main(String[] args) {
		SpringApplication.run(GdtApplication.class, args);
	}

}


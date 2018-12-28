package in.me.gdt.domain;

import java.util.logging.Logger;

import org.springframework.stereotype.Repository;

@Repository
public class UserService {
    Logger logger = Logger.getLogger(UserService.class.toString());

    public void repositoryActionTest() {
        logger.info("action succeded");    
    }
}
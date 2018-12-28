package in.me.gdt;

import java.util.logging.Logger;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    Logger logger = Logger.getLogger(UserRepository.class.toString());

    public void repositoryActionTest() {
        logger.info("action succeded");    
    }
}
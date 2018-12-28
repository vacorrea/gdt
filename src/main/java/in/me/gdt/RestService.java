package in.me.gdt;

import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class RestService {
    private Logger logger = Logger.getLogger(RestService.class.getName());
    @RequestMapping(method=RequestMethod.GET, value="/action")
    public String actionRequest(@RequestParam(value="userName", defaultValue="action") String userName) {
        logger.info(userName);
        return userName;
    }
}
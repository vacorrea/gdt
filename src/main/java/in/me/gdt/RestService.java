package in.me.gdt;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.me.gdt.domain.UserPrincipal;
import in.me.gdt.domain.UserService;

@RestController
@RequestMapping(value="/")
public class RestService {
    private Logger logger = Logger.getLogger(RestService.class.getName());
    @Autowired UserService userService;
    @RequestMapping(method=RequestMethod.GET, value="/action")
    public String actionRequest(@RequestParam(value="userName", defaultValue="action") String userName) {
        logger.info(userName);
        return userName;
    }
    @RequestMapping(method=RequestMethod.GET, value="/load")
    public UserPrincipal userPrincipalRequest(@RequestParam(value="id") Long id) {
        return null;
    }

}
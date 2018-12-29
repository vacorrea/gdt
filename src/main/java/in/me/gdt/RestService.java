package in.me.gdt;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> actionRequest(@RequestParam(value="userName", defaultValue="action") String userName) {
        logger.info(userName);
        return ResponseEntity.status(HttpStatus.OK).body(userName);
    }
    @RequestMapping(method=RequestMethod.GET, value="/load")
    public UserPrincipal userPrincipalRequest(@RequestParam(value="id") Long id) {
        Optional<UserPrincipal> oup = userService.findById(id);        
        return oup.get();
    }

}
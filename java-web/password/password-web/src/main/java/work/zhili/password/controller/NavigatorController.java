package work.zhili.password.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Title : work.zhili.password.controller
 * Description :
 *  - 
 *  -  
 *
 * @author chile
 * @version 1.0
 * @date 2017/9/26 19:36
 */

@Controller
public class NavigatorController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

}

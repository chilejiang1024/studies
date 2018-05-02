package work.zhili.springboot2template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Title : work.zhili.springboot2template.controller <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/5/2 13:28
 */
@Controller
public class NavigationController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

}

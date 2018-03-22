package work.zhili.springboot2template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import work.zhili.springboot2template.service.FirstServiceImpl;

/**
 * Title : work.zhili.springboot2template.controller <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/3/21 18:10
 */
@Controller
public class FirstController {

    @Autowired
    private FirstServiceImpl firstService;

    @GetMapping("/api/v1/first/get")
    public Object firstGet() {
        firstService.firstMethod();
        return "haha";
    }

}

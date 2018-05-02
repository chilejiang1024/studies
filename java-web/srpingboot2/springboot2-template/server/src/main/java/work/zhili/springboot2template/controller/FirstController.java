package work.zhili.springboot2template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import work.zhili.springboot2template.service.impl.FirstServiceImpl;

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
@RequestMapping("/api")
public class FirstController {

    private final FirstServiceImpl firstService;

    @Autowired
    public FirstController(FirstServiceImpl firstService) {
        this.firstService = firstService;
    }

    @GetMapping("/v1/first/get")
    @ResponseBody
    public Object firstGet() {
        firstService.firstMethod();
        return "haha";
    }

}

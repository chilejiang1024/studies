package work.zhili.springboot2template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import work.zhili.springboot2template.core.Status.ReturnMessage;
import work.zhili.springboot2template.core.util.UUIDUtils;
import work.zhili.springboot2template.model.User;
import work.zhili.springboot2template.service.IUserService;

/**
 * Title : work.zhili.springboot2template.controller <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/5/4 14:27
 */
@Controller
@RequestMapping("/api")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/v1/user/get/all")
    @ResponseBody
    public Object queryAll() {
        return userService.queryAllForTesting();
    }

    @PostMapping("/v1/user/add")
    @ResponseBody
    public Object add(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setId(UUIDUtils.getUuid());
        user.setUsername(username);
        user.setPassword(password);
        userService.insert(user);
        return ReturnMessage.SUCCESSFUL_MESSAGE;
    }
}

package work.zhili.springboot2template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Length;
import work.zhili.springboot2template.core.status.ReturnMessage;
import work.zhili.springboot2template.core.util.UUIDUtils;
import work.zhili.springboot2template.model.User;
import work.zhili.springboot2template.service.IUserService;

import javax.validation.Valid;
import javax.validation.constraints.Size;

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

    @GetMapping("/v1/users")
    @ResponseBody
    public Object queryAll() {
        return userService.queryAllForTesting();
    }

    @PostMapping("/v1/users")
    @ResponseBody
    public Object add(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setId(UUIDUtils.getUuid());
        user.setUsername(username);
        user.setPassword(password);
        userService.insert(user);
        return ReturnMessage.SUCCESSFUL_MESSAGE;
    }

    @DeleteMapping("/v1/users/{userId}")
    @ResponseBody
    public Object delete(@PathVariable String userId, Errors errors) {
        if (errors.hasErrors()) {
            throw new RuntimeException("Parameter wrong!");
        }
        userService.delete(userId);
        return ReturnMessage.SUCCESSFUL_MESSAGE;
    }
}

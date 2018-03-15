package work.zhili.password.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import work.zhili.password.mapper.UserMapper;

/**
 * Title : work.zhili.password.controller
 * Description :
 *  - 
 *  -  
 *
 * @author chile
 * @version 1.0
 * @date 2017/9/27 14:18
 */

@Controller
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/test")
    @ResponseBody
    public Object test() {
        return userMapper.queryAllUsers();
    }

}

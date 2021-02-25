package work.zhili.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import work.zhili.websocket.service.impl.TestServiceImpl;

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
public class TestController {

    private final TestServiceImpl firstService;
    private final InstantMessagingController imServer;

    @Autowired
    public TestController(TestServiceImpl firstService, InstantMessagingController imServer) {
        this.firstService = firstService;
        this.imServer = imServer;
    }



    /**
     * test global exception handler
     * @return nothing
     */
    @GetMapping("/v1/first/get")
    @ResponseBody
    Object firstGet() {
        firstService.firstMethod();
        return "haha";
    }

    @PostMapping("/v1/send-message")
    @ResponseBody
    Object sendMessage(@RequestParam String id, @RequestParam String message) {
        imServer.sendMessage(id, message);
        return "ok";
    }

}

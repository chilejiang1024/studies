package work.zhili.springcloud.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import work.zhili.springcloud.eureka.service.ComputeClient;

/**
 * Title : work.zhili.springcloud.eureka.controller <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/8/14 15:56
 */
@RestController
public class ConsumerController {

    @Autowired
    ComputeClient computeClient;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Object add() {
        return computeClient.add(10, 20);
    }

    @RequestMapping(value = "/divide", method = RequestMethod.GET)
    public Object divide(@RequestParam Integer a, @RequestParam Integer b) {
        return computeClient.divide(a, b);
    }
}

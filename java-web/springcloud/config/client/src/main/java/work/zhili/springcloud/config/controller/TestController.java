package work.zhili.springcloud.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title : work.zhili.springcloud.config.controller <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/8/15 15:32
 */
@RefreshScope
@RestController
public class TestController {

    @Value("${hello}")
    private String hello;

    @GetMapping("/hello")
    Object test() {
        return hello;
    }

}

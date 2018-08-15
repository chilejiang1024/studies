package work.zhili.springcloud.eureka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import work.zhili.springcloud.eureka.core.http.response.HttpResponse;

/**
 * Title : work.zhili.springcloud.eureka.controller <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/8/13 13:39
 */
@RestController
public class ComputeController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final DiscoveryClient client;

    @Autowired
    public ComputeController(DiscoveryClient client) {
        this.client = client;
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Object add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getInstances(client.getServices().get(0)).get(0);
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return HttpResponse.success(r);
    }

    @RequestMapping(value = "/divide" ,method = RequestMethod.GET)
    public Object divide(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getInstances(client.getServices().get(0)).get(0);
        if (b == 0) {
            throw new RuntimeException("b cannot be 0");
        }
        Integer r = a / b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return HttpResponse.success(r);
    }

}
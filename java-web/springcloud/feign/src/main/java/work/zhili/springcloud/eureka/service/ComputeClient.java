package work.zhili.springcloud.eureka.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import work.zhili.springcloud.eureka.service.fallback.ComputeClientHystrix;

/**
 * Title : work.zhili.springcloud.eureka.service <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/8/14 15:55
 */
@FeignClient(name = "compute-service", fallback = ComputeClientHystrix.class)
public interface ComputeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Object add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

    @RequestMapping(method = RequestMethod.GET, value = "/divide")
    Object divide(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}

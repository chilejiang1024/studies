package work.zhili.springcloud.eureka.service.fallback;

import org.springframework.stereotype.Component;
import work.zhili.springcloud.eureka.service.ComputeClient;

/**
 * Title : work.zhili.springcloud.eureka.service.fallback <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/8/14 16:34
 */
@Component
public class ComputeClientHystrix implements ComputeClient {

    @Override
    public Object add(Integer a, Integer b) {
        return Integer.MIN_VALUE;
    }

    @Override
    public Object divide(Integer a, Integer b) {
        return 0;
    }
}

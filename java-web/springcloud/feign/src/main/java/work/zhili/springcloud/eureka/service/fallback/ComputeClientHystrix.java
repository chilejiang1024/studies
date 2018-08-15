package work.zhili.springcloud.eureka.service.fallback;

import org.springframework.stereotype.Component;
import work.zhili.springcloud.eureka.service.ComputeClient;

/**
 * Title : work.zhili.springcloud.eureka.service.fallback <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
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
    public Integer add(Integer a, Integer b) {
        return Integer.MIN_VALUE;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        return 0;
    }
}

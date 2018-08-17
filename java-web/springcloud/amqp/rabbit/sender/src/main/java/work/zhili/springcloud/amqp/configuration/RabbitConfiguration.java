package work.zhili.springcloud.amqp.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title : work.zhili.springcloud.amqp.configuration <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/8/17 14:30
 */
@Configuration
public class RabbitConfiguration {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}

package work.zhili.springcloud.amqp.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Title : work.zhili.springcloud.amqp <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/8/17 14:23
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @RabbitHandler
    void handler(String msg) {
        logger.info("receive: " + msg);
    }
}

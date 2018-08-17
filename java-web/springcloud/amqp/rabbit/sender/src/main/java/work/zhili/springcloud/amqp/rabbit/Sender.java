package work.zhili.springcloud.amqp.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Title : work.zhili.springcloud.amqp <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/8/17 14:20
 */
@Component
public class Sender {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private final AmqpTemplate amqpTemplate;

    @Autowired
    public Sender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void send(String msg) {
        logger.info("send: " + msg);
        amqpTemplate.convertAndSend("hello", msg);
    }
}

package work.zhili.springcloud.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import work.zhili.springcloud.amqp.rabbit.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitSenderApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void send() {
        sender.send("路漫漫其修远兮 吾将上下而求索");
    }

}

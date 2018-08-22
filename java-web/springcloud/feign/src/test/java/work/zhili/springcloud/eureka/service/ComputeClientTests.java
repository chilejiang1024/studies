package work.zhili.springcloud.eureka.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * Title : work.zhili.springcloud.eureka.service <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/8/22 10:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ComputeClientTests {

    @Autowired
    ComputeClient computeClient;

    @Test
    public void add() {
        Object o = computeClient.add(1, 1);
        assert Objects.equals(2, ((LinkedHashMap) o).get("data"));
        System.out.println("add method tests pass.");
    }

    @Test
    public void divide() {
        Object o = computeClient.divide(1, 1);
        assert Objects.equals(1, ((LinkedHashMap) o).get("data"));

        o = computeClient.divide(1, 0);
        assert Objects.equals(0, o);

        System.out.println("divide method tests pass.");
    }

}

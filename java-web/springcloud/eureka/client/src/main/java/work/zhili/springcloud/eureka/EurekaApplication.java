package work.zhili.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Title : work.zhili.springcloud.eureka.EurekaApplication <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description : <br>
 *   eureka test
 *
 * @author zhili
 * @version 1.0
 * @date 2018-8-13 10:43:32
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}

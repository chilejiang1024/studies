package work.zhili.springcloud.eureka.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title : work.zhili.springcloud.eureka.config <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/6/4 11:03
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}

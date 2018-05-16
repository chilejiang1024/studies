package work.zhili.springboot2template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Title : work.zhili.springboot2template <br>
 * Description :
 *  <p>
 *  <ul>
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/3/21 18:10
 */
@SpringBootApplication
public class Springboot2TemplateApplication {

    private static Logger logger = LoggerFactory.getLogger(Springboot2TemplateApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Springboot2TemplateApplication.class, args);
        logger.info("application was started ...");
    }
}

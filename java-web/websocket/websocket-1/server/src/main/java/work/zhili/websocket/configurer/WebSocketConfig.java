package work.zhili.websocket.configurer;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import work.zhili.websocket.core.filter.SampleFilter;

import javax.servlet.DispatcherType;

/**
 * Title : work.zhili.springboot2template.configurer <br>
 * Description :
 *   add filters
 *
 * @author chile
 * @version 1.0
 * @date 2018-4-17 13:43:19
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}

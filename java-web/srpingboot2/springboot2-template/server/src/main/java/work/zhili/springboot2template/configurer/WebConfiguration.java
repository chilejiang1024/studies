package work.zhili.springboot2template.configurer;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new Filter() {
            @Override
            public void init(FilterConfig filterConfig) throws ServletException {

            }

            @Override
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                                 FilterChain filterChain) throws IOException, ServletException {

            }

            @Override
            public void destroy() {

            }
        });
        registration.addUrlPatterns("/lawyer/*", "/ajypfx/*", "/recognition/*", "/typesetting/*", "/loginStatusValidate");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("loginStatusCheckFilter");
        registration.setOrder(1);
        return registration;
    }

}

package main.frameworks.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Title : main.chile.redis
 * Description :
 *  <p>
 *  <ul> 
 *    <li>  </li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/1/11 16:29
 */

public class CustomRedisTemplate {

    @Bean
    private static JedisConnectionFactory getJedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("172.23.4.63");
        factory.setDatabase(0);
        return factory;
    }

    @Bean
    public static RedisTemplate<String, Object> getRedisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(getJedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new GenericToStringSerializer<>( Object.class ));
        template.setValueSerializer(new GenericToStringSerializer<>( Object.class ));
        return template;
    }

}

package main.chile.redis;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * Title : main.chile.redis
 * Description :
 *  <p>
 *  <ul> 
 *    <li>  </li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/1/11 16:46
 */

public class RedisTest {

    private static RedisTemplate<String, Object> redisTemplate;

    static  {
        redisTemplate = CustomRedisTemplate.getRedisTemplate();
    }

    public static void main(String[] args) {
        redisTemplate.opsForValue().set("key:1", "value:1");
    }

}

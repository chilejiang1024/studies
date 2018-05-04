package work.zhili.springboot2template.service;

import org.springframework.stereotype.Service;
import work.zhili.springboot2template.model.User;

import java.util.List;

/**
 * Title : work.zhili.springboot2template.service <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/5/4 14:18
 */
public interface IUserService {

    /**
     * just for testing
     * @return {User, ...}
     */
    List<User> queryAllForTesting();

}

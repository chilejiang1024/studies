package work.zhili.springboot2template.dao;

import org.springframework.stereotype.Component;
import work.zhili.springboot2template.model.User;

import java.util.List;

/**
 * Title : work.zhili.springboot2template.dao <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/4/17 11:17
 */
@Component
public interface IUserMapper {

    /**
     * a test of dao
     * @return {User, ...}
     */
    List<User> queryAllForTesting();

    /**
     * insert a user
     * @param user the user
     */
    void insert(User user);
}

package work.zhili.springboot2template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import work.zhili.springboot2template.dao.IUserMapper;
import work.zhili.springboot2template.model.User;
import work.zhili.springboot2template.service.IUserService;

import java.util.List;

/**
 * Title : work.zhili.springboot2template.service.impl <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/5/4 14:19
 */
@Service
public class UserServiceImpl implements IUserService {

    private final IUserMapper userMapper;

    @Autowired
    public UserServiceImpl(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Cacheable(cacheNames = "user", key = "#root.method.name")
    public List<User> queryAllForTesting() {
        return userMapper.queryAllForTesting();
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}

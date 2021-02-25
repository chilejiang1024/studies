package work.zhili.websocket.service.impl;

import org.springframework.stereotype.Service;
import work.zhili.websocket.service.ITestService;

/**
 * Title : work.zhili.springboot2template.service <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/3/21 18:42
 */
@Service
public class TestServiceImpl implements ITestService {

    @Override
    public void firstMethod() {
        throw new RuntimeException("Runtime exception for testing ...");
    }

}

package main.frameworks.some.override;

import static java.lang.System.out;

/**
 * Title : main.chile.some
 * Company : 北京华宇元典信息服务有限公司
 * Description :
 *  <ul> 
 *    <li>  </li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2017/12/12 11:20
 */

public class OverrideSuperClassStaticMethod extends SuperClass {

    // @Override
    public static void print() {
        out.print("sub class print.");
    }

}

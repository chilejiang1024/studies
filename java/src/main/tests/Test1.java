package main.tests;

import org.junit.Test;

/**
 * Title : main.tests <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/3/13 11:02
 */
public class Test1 {

    @Test
    public void test1() {
        int i = 0x000f000f;

        System.out.println(i);

        System.out.println(i >> 16);
        System.out.println(i << 16);

        System.out.println(i & 0x0000ffff);
        System.out.println((i & 0xffff0000) >> 16);

    }

}

package main.java8.basics.time.localdate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Title : main.java8.basics.time.localdate <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/8/28 14:29
 */
public class ClassA {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate bornDate = LocalDate.of(1994, 10, 11);
        System.out.println(bornDate.until(now, ChronoUnit.DAYS));
    }

}

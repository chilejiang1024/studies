package main.java8.basics.time.localdate;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Title : main.java8.basics.time.localdate <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/8/28 14:29
 */
public class LocalDateTest {

    /**
     * 两个日期之间的间隔天数
     */
    @Test
    public void test1() {
        LocalDate now = LocalDate.now();
        LocalDate bornDate = LocalDate.of(1994, 10, 11);
        System.out.println(bornDate.until(now, ChronoUnit.DAYS));
        System.out.println(ChronoUnit.DAYS.between(bornDate, now));
    }

    /**
     * 今天是今年的第几天
     */
    @Test
    public void test2() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getDayOfYear());
    }

    /**
     * 格式化
     */
    @Test
    public void test3() {
        String dateStr = "20181112";
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        // 不加 formatter 会抛异常
        System.out.println(LocalDate.parse(dateStr, formatter));
    }
}

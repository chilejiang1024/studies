package main.java8.tricks;

import java.util.Objects;

import static java.lang.System.out;

/**
 * Title : main.java8.tricks <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/3/29 9:35
 */
public class Equals {

    public static void main(String[] args) {
        Object a  = "aaa";
        Object aa = "aaa";
        Object b  = 123;
        Object c  = a;
        Object d  = null;

        out.println(way1(a, b));
        out.println(way1(a, d));
        out.println(way1(a, aa));

        out.println(way2(a, b));
        out.println(way2(a, c));
        out.println(way2(a, d));
        out.println(way2(a, aa));
    }

    private static boolean way1(Object a, Object b) {
        return Objects.equals(a, b);
    }

    private static boolean way2(Object a, Object b) {
        return a == b || Objects.equals(a, b);
    }

}

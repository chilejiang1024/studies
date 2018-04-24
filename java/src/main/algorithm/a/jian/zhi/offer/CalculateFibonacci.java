package main.algorithm.a.jian.zhi.offer;

import static java.lang.System.out;

/**
 * Title : main.algorithm.a.jian.zhi.offer <br>
 * Description :
 *  <p>
 * @author chile
 * @version 1.0
 * @date 2018/4/24 9:46
 */
public class CalculateFibonacci {

    public static void main(String[] args) {
        out.println(method1(5));
        out.println(method1(-5));
    }

    private static int method1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return method1(n - 1) + method1(n - 2);
    }
}

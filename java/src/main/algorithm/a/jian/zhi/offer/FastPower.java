package main.algorithm.a.jian.zhi.offer;

import static java.lang.System.out;

/**
 * Title : main.algorithm.a.jian.zhi.offer <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/5/11 10:16
 */
public class FastPower {

    public static void main(String[] args) {
        standard(5, 5);
        fastPower(5, 5);

        standard(5, 6);
        fastPower(5, 6);
    }

    /**
     * time complexity : O(n)
     * @param base   base number
     * @param power  power number
     */
    private static void standard(int base, int power) {
        int result = 1, tempPower = power;
        while (tempPower > 0) {
            result *= base;
            tempPower--;
        }
        out.println(base + "^" + power + "=" + result);
    }

    /**
     * fast power
     * time complexity : O(log n)
     * @param base  base number
     * @param power power number
     */
    private static void fastPower(int base, int power) {
        int result = 1, tempPower = power, tempBase = base;
        while (tempPower > 0) {
            if ((tempPower & 1) == 1) {
                result *= tempBase;
            }
            tempPower >>= 1;
            tempBase *= tempBase;
        }
        out.println(base + "^" + power + "=" + result);
    }

}

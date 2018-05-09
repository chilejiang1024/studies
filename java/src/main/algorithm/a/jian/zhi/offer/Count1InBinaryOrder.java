package main.algorithm.a.jian.zhi.offer;

/**
 * Title : main.algorithm.a.jian.zhi.offer <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/5/9 17:04
 */
public class Count1InBinaryOrder {

    private static int count(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    private static int count1(int n) {
        int count = 0;
        int flag  = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        //  10 : 0000 0000 0000 0000 0000 0000 0000 1010
        // -10 : 1111 1111 1111 1111 1111 1111 1111 0101
        int c = count1(-10);
        System.out.println(c);
    }
}

package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Runtime: 1 ms, faster than 100.00% of Java online submissions for Sqrt(x).
 *   <p> Memory Usage: 33.6 MB, less than 5.12% of Java online submissions for Sqrt(x).
 * @author chile
 * @version 1.0
 * @date 2019/7/17 15:03
 */
public class Sqrt {

    class Solution {
        public int mySqrt(int x) {
            int maxEnd = 46340;

            if (x >= 2147395600) {
                return maxEnd;
            }
            if (x == 1) {
                return 1;
            }

            int s = 0, e = x > 5 ? x / 2 > maxEnd ? maxEnd : x / 2 : x;
            double t = 0;

            while (e - s > 1) {
                t = Math.pow((s + e) / 2, 2);
                if (t == x) {
                    return (s + e) / 2;
                } else if (x > t) {
                    s = (s + e) / 2;
                } else {
                    e = (s + e) / 2;
                }
            }
            return s;
        }
    }

    @Test
    public void test1() {
        assert new Solution().mySqrt(100) == 10;
    }

    @Test
    public void test2() {
        assert new Solution().mySqrt(8) == 2;
    }

}

package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/5/27 10:26
 */
public class PowerOfThree {



    public static class Solution {
        private static int THE_MAX_NUM = 0;

        public void calculateTheMax() {
            double n = 0;
            for (int i = 1; ; i++) {
                n = Math.pow(3, i);
                if (n > Integer.MAX_VALUE) {
                    THE_MAX_NUM = (int) (n / 3);
                    System.out.println(THE_MAX_NUM);
                    break;
                }
            }
        }

        public boolean isPowerOfThree(int n) {
            return 1162261467 % n == 0;
        }
    }

    public static void main(String[] args) {
        new Solution().calculateTheMax();
        assert new Solution().isPowerOfThree(0);
        assert !new Solution().isPowerOfThree(45);
    }

    @Test
    public void test1() {
        assert new Solution().isPowerOfThree(27);
        assert new Solution().isPowerOfThree(0);
        assert !new Solution().isPowerOfThree(45);
    }

}

package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 * <p> Runtime: 14 ms, faster than 89.66% of Java online submissions for Reverse Integer.
 * <p> Memory Usage: 38 MB, less than 38.00% of Java online submissions for Reverse Integer.
 * @author chile
 * @version 1.0
 * @date 2019/3/18 13:29
 */
public class ReverseInteger {

    class Solution {
        public int reverse(int x) {
            if (x == Integer.MIN_VALUE) {
                return 0;
            }

            boolean negative = x < 0;
            x = negative ? -1 * x : x;

            int length = 0;
            int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
                    99999999, 999999999, Integer.MAX_VALUE };
            for (int i = 0; ; i++) {
                if (x <= sizeTable[i]) {
                    length = i + 1;
                    break;
                }
            }

            int[] carryTable = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000,
            100000000, 1000000000};

            long result = 0;
            int n = 0;
            for (int i = 0; i < length; i++) {
                n = x % 10;
                result += 1.0 * n * carryTable[length - i - 1];
                if (length == 10 && result > Integer.MAX_VALUE) {
                    return 0;
                }
                x =  div10(x);
            }

            return (int) (negative ? -1 * result : result);
        }

        public int div10(int n) {

            int q, r;
            q = (n >> 1) + (n >> 2);
            q = q + (q >> 4);
            q = q + (q >> 8);
            q = q + (q >> 16);
            q = q >> 3;
            r = n - (((q << 2) + q) << 1);
            return q + (r > 9 ? 1 : 0);

        }

        public int reverse2(int x) {
            boolean negative = x < 0;

            String xStr = String.valueOf(x);
            if (negative) {
                xStr = xStr.substring(1);
            }
            char[] chars = xStr.toCharArray();

            char t;
            for (int i = 0, l = chars.length; i < l / 2; i++) {
                t = chars[i];
                chars[i] = chars[l - i - 1];
                chars[l - i - 1] = t;
            }
            String yStr = String.valueOf(chars);

            int result = 0;
            try {
                result = Integer.valueOf(yStr);
            } catch (Exception ignored) {}

            return negative ? -1 * result : result;
        }
    }

    @Test
    public void test1() {
        assert new Solution().reverse(-1234) == -4321;
    }

    @Test
    public void test2() {
        assert new Solution().reverse(120) == 21;
    }

    @Test
    public void test3() {
        assert new Solution().reverse(1534236469) == 0;
    }

    @Test
    public void test5() {
        assert new Solution().reverse(2147483647) == 0;
    }

    @Test
    public void test6() {
        assert new Solution().reverse(-2147483648) == 0;
    }

    @Test
    public void test4() {
        assert new Solution().div10(10) == 1;
        assert new Solution().div10(9) == 0;
        assert new Solution().div10(100) == 10;
        assert new Solution().div10(99) == 9;
        assert new Solution().div10(567) == 56;
    }

}

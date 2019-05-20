package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Runtime: 1 ms, faster than 100.00% of Java online submissions for String to Integer (atoi).
 *   <p> Memory Usage: 35.1 MB, less than 99.98% of Java online submissions for String to Integer (atoi).
 * @author chile
 * @version 1.0
 * @date 2019/5/20 14:37
 */
public class StringToInteger {

    class Solution {

        public int myAtoi(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }

            long value = 0;
            long positive = 1;
            boolean start = false;
            char n = '\0';

            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                n = chars[i];
                if (!start && n != ' ') {
                    start = true;
                    if (n == '-') {
                        positive = -1;
                        continue;
                    } else if (n == '+') {
                        continue;
                    } else if (n >= '0' && n <= '9') {

                    } else {
                        return 0;
                    }
                }

                if (start) {
                    if (n >= '0' && n <= '9') {
                        value = value * 10 + (n - '0');
                        if (value * positive > Integer.MAX_VALUE) {
                            return Integer.MAX_VALUE;
                        }
                        if (value * positive < Integer.MIN_VALUE) {
                            return Integer.MIN_VALUE;
                        }
                    } else {
                        return (int) (value * positive);
                    }
                }

            }

            return (int) (value * positive);
        }

    }

    @Test
    public void test1() {
        String str = "   ";
        assert new Solution().myAtoi(str) == 0;
    }

    @Test
    public void test2() {
        String str = "  w ";
        assert new Solution().myAtoi(str) == 0;
    }

    @Test
    public void test3() {
        String str = "  100 ";
        assert new Solution().myAtoi(str) == 100;
    }

    @Test
    public void test4() {
        String str = "  -42 ";
        assert new Solution().myAtoi(str) == -42;
    }

    @Test
    public void test5() {
        String str = "  4123 sdfasdf dadf ";
        assert new Solution().myAtoi(str) == 4123;
    }

    @Test
    public void test6() {
        String str = "  -91283472332";
        assert new Solution().myAtoi(str) == -2147483648;
    }
}

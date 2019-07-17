package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *  <p> Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Binary.
 *  <p> Memory Usage: 36.4 MB, less than 99.92% of Java online submissions for Add Binary.
 * @author chile
 * @version 1.0
 * @date 2019/7/17 13:54
 */
public class AddBinary {

    class Solution {
        public String addBinary(String a, String b) {
            if (a.length() < b.length()) {
                String t = a;
                a = b;
                b = t;
            }
            int la = a.length(), lb = b.length(), carry = 0, num = 0;
            char[] c = new char[la + 1];
            for (int i = 0; i < c.length; i++) {
                if (i < lb) {
                    num = (a.charAt(la - i - 1) + b.charAt(lb - i - 1) + carry - 2 * '0') % 2;
                    c[c.length - i - 1] = (char) ('0' + num);
                    carry = (a.charAt(la - i - 1) + b.charAt(lb - i - 1) + carry - 2 * '0') / 2;
                } else if (i < la) {
                    num = (a.charAt(la - i - 1) + carry - '0') % 2;
                    c[c.length - i - 1] = (char) ('0' + num);
                    carry = (a.charAt(la - i - 1) + carry - '0') / 2;
                } else if (carry > 0) {
                    num = carry;
                    c[c.length - i - 1] = (char) ('0' + num);
                }
            }

            return carry > 0 ? String.valueOf(c) : String.valueOf(c, 1, la);
        }
    }

    @Test
    public void test1() {
        assert "100".equals(new Solution().addBinary("11", "1"));
    }

    @Test
    public void test2() {
        assert "10101".equals(new Solution().addBinary("1010", "1011"));
    }

    @Test
    public void test3() {
        assert "110110".equals(new Solution().addBinary("100", "110010"));
    }
}

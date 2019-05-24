package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
 *   <p> Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Plus One.
 * @author chile
 * @version 1.0
 * @date 2019/5/24 11:33
 */
public class PlusOne {

    class Solution {

        public int[] plusOne(int[] digits) {
            int l = digits.length;

            for (int i = l - 1; i >= 0; i--) {
                if (digits[i] + 1 == 10) {
                    digits[i] = 0;
                    if (i == 0) {
                        int[] r = new int[l + 1];
                        r[0] = 1;
                        System.arraycopy(digits, 0, r, 1, l);
                        digits = r;
                    }
                } else {
                    digits[i]++;
                    break;
                }
            }

            return digits;
        }

    }

    @Test
    public void test1() {
        int[] digits = { 1, 2, 3 };
        int[] result = new Solution().plusOne(digits);
        assert result[0] == 1;
        assert result[1] == 2;
        assert result[2] == 4;
    }

    @Test
    public void test2() {
        int[] digits = { 1, 2, 9 };
        int[] result = new Solution().plusOne(digits);
        assert result[0] == 1;
        assert result[1] == 3;
        assert result[2] == 0;
    }

    @Test
    public void test3() {
        int[] digits = { 0 };
        int[] result = new Solution().plusOne(digits);
        assert result[0] == 1;
    }

}

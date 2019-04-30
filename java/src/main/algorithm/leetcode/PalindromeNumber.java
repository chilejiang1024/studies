package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Runtime: 6 ms, faster than 100.00% of Java online submissions for Palindrome Number.
 *   <p> Memory Usage: 35 MB, less than 100.00% of Java online submissions for Palindrome Number.
 * @author chile
 * @version 1.0
 * @date 2019/4/30 13:54
 */
public class PalindromeNumber {

    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            int originX = x;
            long result = 0;
            while (x != 0) {
                result = result * 10 + x % 10;
                x /= 10;
            }

            return result == originX;
        }
    }

    @Test
    public void test1() {
        assert new Solution().isPalindrome(121);
    }

    @Test
    public void test2() {
        assert !new Solution().isPalindrome(-121);
    }

    @Test
    public void test3() {
        assert !new Solution().isPalindrome(10);
    }

}

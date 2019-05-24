package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Runtime: 17 ms, faster than 56.87% of Java online submissions for Longest Palindromic Substring.
 *   <p> Memory Usage: 35.3 MB, less than 99.80% of Java online submissions for Longest Palindromic Substring.
 * @author chile
 * @version 1.0
 * @date 2019/5/23 18:25
 */
public class LongestPalindromicSubstring {

    class Solution {
        /**
         * expand around center
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            if (s.length() == 1) {
                return s;
            }

            char[] chars = new char[s.length() * 2 - 1];
            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    chars[i] = s.charAt(i / 2);
                } else {
                    chars[i] = '#';
                }
            }

            int index = 0;
            int length = 0;
            int tempLength = 0;
            for (int i = 0; i < chars.length; i++) {
                tempLength = calPali(chars, i);
                if (chars[i - tempLength / 2] == '#') {
                    tempLength -= 2;
                }
                if (tempLength > length) {
                    index = i;
                    length = tempLength;
                }
            }

            return new String(chars, index - length / 2, length).replaceAll("#", "");
        }

        /**
         * calculate the length of longest sub palindrome string
         * @param chars char set
         * @param index index of central char
         * @return length of longest sub palindrome string
         */
        private int calPali(char[] chars, int index) {
            int leftBound = index;
            int rightBound = chars.length - index - 1;
            int bound = leftBound > rightBound ? rightBound : leftBound;
            for (int i = 0; i < bound; i++) {
                if (chars[index - i - 1] == chars[index + i + 1]) {

                } else {
                    return 2 * i + 1;
                }
            }
            return 2 * bound + 1;
        }

    }

    @Test
    public void test1() {
        assert new Solution().longestPalindrome("caba").equals("aba");
    }

    @Test
    public void test2() {
        assert new Solution().longestPalindrome("abb").equals("bb");
    }
}

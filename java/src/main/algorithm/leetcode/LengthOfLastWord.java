package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/7/17 11:16
 */
public class LengthOfLastWord {

    class Solution {
        public int lengthOfLastWord1(String s) {
            int l = 0;

            if (s == null || s.length() == 0) {
                return l;
            }

            String[] split = s.split(" +");
            if (split.length > 0) {
                l = split[split.length - 1].length();
            }

            return l;
        }

        public int lengthOfLastWord(String s) {
            int l = 0;
            boolean has = false;

            if (s == null || s.length() == 0) {
                return l;
            }

            for (int i = s.length() - 1; i > -1; i--) {
                if (!has) {
                    if (s.charAt(i) != ' ') {
                        has = true;
                        l++;
                    }
                } else {
                    if (s.charAt(i) == ' ') {
                        return l;
                    } else {
                        l++;
                    }
                }
            }

            return l;
        }
    }

    @Test
    public void test1() {
        String s = "Hello world";
        assert new Solution().lengthOfLastWord(s) == 5;
    }

    @Test
    public void test2() {
        String s = "Hello world  ";
        assert new Solution().lengthOfLastWord(s) == 5;
    }

}

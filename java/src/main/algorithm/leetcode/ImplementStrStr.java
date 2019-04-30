package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *  2ms
 *
 * @author chile
 * @version 1.0
 * @date 2019/4/29 11:31
 */
public class ImplementStrStr {

    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle == null || needle.length() == 0) {
                return 0;
            }
            int k = 0;
            int index = -1;
            for (int i = 0, j = 0; i < haystack.length() - needle.length() + 1;) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    index = i;
                    k = i + 1;
                    j++;
                    while (j < needle.length()) {
                        if (haystack.charAt(k++) != needle.charAt(j++)) {
                            index = -1;
                            j = 0;
                            i++;
                            break;
                        }
                     }
                } else {
                    i++;
                }
                if (index > -1) {
                    return index;
                }
            }
            return index;
        }
    }

    @Test
    public void test1() {
        String haystack = "abc";
        String needle = "a";
        assert new Solution().strStr(haystack, needle) == 0;
    }

    @Test
    public void test2() {
        String haystack = "erfgs";
        String needle = "fg";
        assert new Solution().strStr(haystack, needle) == 2;
    }

    @Test
    public void test3() {
        String haystack = "aaaaab";
        String needle = "ba";
        assert new Solution().strStr(haystack, needle) == -1;
    }

    @Test
    public void test4() {
        String haystack = "mississippi";
        String needle = "mississippi";
        assert new Solution().strStr(haystack, needle) == 0;
    }

}

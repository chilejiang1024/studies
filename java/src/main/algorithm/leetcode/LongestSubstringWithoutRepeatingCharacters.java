package main.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 * <p> Runtime: 23 ms, faster than 75.70% of Java online submissions for Longest Substring Without Repeating Characters.
 * <p> Memory Usage: 39.3 MB, less than 20.94% of Java online submissions for Longest Substring Without Repeating Characters.
 * @author chile
 * @version 1.0
 * @date 2019/3/15 15:29
 */
public class LongestSubstringWithoutRepeatingCharacters {

    static class Solution {

        public int lengthOfLongestSubstring(String s) {
            int h = 0, t = 0, ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0, l = s.length(); i < l; i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    if (map.get(c) >= h) {
                        ans = Math.max(ans, i - h);
                        h = map.get(c) + 1;
                    }
                }
                ans = Math.max(ans, i - h + 1);
                map.put(c, i);
            }

            return ans;
        }

    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }

    @Test
    public void test1() {
        String s = "aabaab!bb";
        int n = new Solution().lengthOfLongestSubstring(s);
        assert n == 3;
    }

    @Test
    public void test2() {
        String s = "abcabcbb";
        int n = new Solution().lengthOfLongestSubstring(s);
        assert n == 3;
    }

    @Test
    public void test3() {
        String s = "a";
        int n = new Solution().lengthOfLongestSubstring(s);
        assert n == 1;
    }

    @Test
    public void test4() {
        String s = "pwwkew";
        int n = new Solution().lengthOfLongestSubstring(s);
        assert n == 3;
    }

    @Test
    public void test5() {
        String s = "";
        int n = new Solution().lengthOfLongestSubstring(s);
        assert n == 0;
    }

    @Test
    public void test6() {
        String s = "   ";
        int n = new Solution().lengthOfLongestSubstring(s);
        assert n == 1;
    }

    @Test
    public void test7() {
        String s = "dvdf";
        int n = new Solution().lengthOfLongestSubstring(s);
        assert n == 3;
    }

    @Test
    public void test8() {
        String s = "tmmzuxt";
        int n = new Solution().lengthOfLongestSubstring(s);
        assert n == 5;
    }

}

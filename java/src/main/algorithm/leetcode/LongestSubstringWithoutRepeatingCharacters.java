package main.algorithm.leetcode;

import org.junit.Test;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.util.*;

/**
 * Title : main.algorithm.leetcode <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
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
                if (map.containsKey(s.charAt(i))) {
                    ans = Math.max(ans, i - h);
                    h = Math.max(h, map.get(s.charAt(i)) + 1);
                    map.put(s.charAt(i), i);
                } else {
                    map.put(s.charAt(i), i);
                    ans = Math.max(ans, i - h + 1);
                }
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
}

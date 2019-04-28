package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *  <a href="https://leetcode.com/problems/longest-common-prefix">problem</a>
 *
 * @author chile
 * @version 1.0
 * @date 2019/4/28 13:13
 */
public class LongestCommonPrefix {

    class Solution {
        String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            if (strs.length < 2) {
                return strs[0];
            }

            String commonPrefix = getCommonPrefix(strs[0], strs[1]);
            for (int i = 2; i < strs.length; i++) {
                commonPrefix = getCommonPrefix(strs[i], commonPrefix);
            }

            return commonPrefix;
        }

        String getCommonPrefix(String str1, String commonPrefix) {
            for (int i = 0; i < commonPrefix.length(); i++) {
                while (str1.indexOf(commonPrefix) != 0) {
                    commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
                }
            }
            return commonPrefix;
        }
    }

    @Test
    public void test1() {
        String[] strs = { "flower", "flow", "flight" };
        assert "fl".equals(new Solution().longestCommonPrefix(strs));
    }

    @Test
    public void test2() {
        assert new Solution().getCommonPrefix("flaaa", "fleee").equals("fl");
    }
}

package main.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Runtime: 1 ms, faster than 93.46% of Java online submissions for Generate Parentheses.
 *   <p> Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Generate Parentheses.
 * @author chile
 * @version 1.0
 * @date 2019/5/24 16:51
 */
public class GenerateParentheses {

    class Solution {
        public ArrayList<String> generateParenthesis(int n) {
            ArrayList<String> result = new ArrayList<>();
            if (n <= 0) {
                return result;
            }
            dfs(0, 0, "", result, n);
            return result;
        }

        private void dfs(int left, int right, String builder, List<String> result, int n) {
            if (left == n && right == n) {
                result.add(builder);
                return;
            }
            if (left < n) {
                dfs(left + 1, right, builder + "(", result, n);
            }
            if (left > right) {
                dfs(left, right + 1, builder + ")", result, n);
            }
        }

    }

    @Test
    public void test1() {
        ArrayList<String> strings = new Solution().generateParenthesis(3);
        strings.forEach(System.out::println);
    }

}

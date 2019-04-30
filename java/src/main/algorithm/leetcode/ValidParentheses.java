package main.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   <p> Runtime: 1 ms, faster than 99.29% of Java online submissions for Valid Parentheses.
 *   <p> Memory Usage: 35.4 MB, less than 37.18% of Java online submissions for Valid Parentheses.
 * @author chile
 * @version 1.0
 * @date 2019/4/30 11:24
 */
public class ValidParentheses {

    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }

            boolean result = false;
            ArrayDeque<Character> stack = new ArrayDeque<>();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (indexOf(c) < 3) {
                    stack.addFirst(c);
                } else {
                    if (!stack.isEmpty() && indexOf(c) - indexOf(stack.getFirst()) == 3) {
                        stack.removeFirst();
                    } else {
                        return result;
                    }
                }
            }

            return stack.isEmpty();
        }

        public int indexOf(char c) {
            if (c == '(') {
                return 0;
            }
            if (c == '[') {
                return 1;
            }
            if (c == '{') {
                return 2;
            }
            if (c == ')') {
                return 3;
            }
            if (c == ']') {
                return 4;
            }
            if (c == '}') {
                return 5;
            }
            return -1;
        }
    }

    @Test
    public void test1() {
        assert new Solution().isValid("(){}[]") == true;
    }

}

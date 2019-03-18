package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 * <p> Runtime: 24 ms
 * <p> Memory Usage: 40.8 MB
 * @author chile
 * @version 1.0
 * @date 2019/3/18 16:31
 */
public class ZigZagConversion {

    class Solution {
        /**
         * not good enough
         * @param s
         * @param numRows
         * @return
         */
        public String convert(String s, int numRows) {
            int r = numRows, c = 0, l = s.length();

            if (r == 1) {
                return s;
            }

            int numGroups = l / (r + r - 2);
            int numGrouped = numGroups * (r + r - 2);
            c = numGroups * (r - 1) + (l - numGrouped > r ? l - numGrouped - r + 1 : 1);

            int i = 0, j = 0, x = 1, y = 0;
            char[] words = s.toCharArray();
            char[][] matrix = new char[r][c];
            for (char w : words) {
                matrix[i][j] = w;
                if (i == 0) {
                    x = 1;
                    y = 0;
                }
                if (i == r - 1) {
                    x = -1;
                    y = 1;
                }
                i += x;
                j += y;
            }

            char ch = '\u0000';
            StringBuilder sb = new StringBuilder();
            for (i = 0; i < r; i++) {
                for (j = 0; j < c; j++) {
                    if (matrix[i][j] != ch) {
                        sb.append(matrix[i][j]);
                    }
                }
            }

            // System.out.println(sb.toString());

            return sb.toString();
        }
    }

    @Test
    public void test1() {
        assert new Solution().convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR");
    }

    @Test
    public void test2() {
        assert new Solution().convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI");
    }

    @Test
    public void test3() {
        assert new Solution().convert("ABCDE", 4).equals("ABCED");
    }

}

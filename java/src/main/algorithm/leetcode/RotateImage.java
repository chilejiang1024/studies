package main.algorithm.leetcode;

import org.junit.Test;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *   Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
 *   Memory Usage: 39.7 MB, less than 5.77% of Java online submissions for Rotate Image.
 * @author chile
 * @version 1.0
 * @date 2020/4/20 13:56
 */
public class RotateImage {

    class Solution {
        public void rotate(int[][] matrix) {
            if (matrix.length < 2) {
                return;
            }

            int f = 0;
            while (matrix.length - 2 * f > 1) {
                rotateAt(matrix, f++);
            }

        }

        private void rotateAt(int[][] matrix, int f) {
            int temp, n = matrix.length;
            int[][] pointer = {
                    {f, f},
                    {f, n - 1 -f},
                    {n - 1 -f, n - 1 -f},
                    {n - 1 -f, f}
            };
            for (int i = 0; i < n - 2 * f - 1; i++) {
                temp = matrix[pointer[0][0]][pointer[0][1] + i];
                matrix[pointer[0][0]][pointer[0][1] + i] = matrix[pointer[3][0] - i][pointer[3][1]];
                matrix[pointer[3][0] - i][pointer[3][1]] = matrix[pointer[2][0]][pointer[2][1] - i];
                matrix[pointer[2][0]][pointer[2][1] - i] = matrix[pointer[1][0] + i][pointer[1][1]];
                matrix[pointer[1][0] + i][pointer[1][1]] = temp;
            }
        }

        private void printMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    @Test
    public void test1() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        new Solution().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        new Solution().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}

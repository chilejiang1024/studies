package main.algorithm.a.jian.zhi.offer;

import static java.lang.System.out;

/**
 * Title : main.algorithm.a.jian.zhi.offer <br>
 * Description : <br>
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * Consider the following matrix:
 * [
 *     [1,   4,  7, 11, 15],         a[0][0] a[0][1] ... a[0][4]
 *     [2,   5,  8, 12, 19],         a[1][0] a[1][1] ... a[1][4]
 *     [3,   6,  9, 16, 22],
 *     [10, 13, 14, 17, 24],
 *     [18, 21, 23, 26, 30]
 * ]
 * 
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 * > 这个只能从右上或者左下下手
 * 
 * @author chile
 * @version 1.0
 * @date 2018/4/11 10:31
 */
public class FindNumberIn2DMatrix {

    public static void main(String[] args) {
        int[][] a = {{1,   4,  7, 11, 15}, 
                     {2,   5,  8, 12, 19}, 
                     {3,   6,  9, 16, 22}, 
                     {10, 13, 14, 17, 24}, 
                     {18, 21, 23, 26, 30}};
        int b = 18;
        boolean found = findTheNumber(a, b);

        out.println("Given target = " + b + ", return " + (found ? "true." : "false."));
    }

    private static boolean findTheNumber(int[][] a, int b) {
        int w = a[0].length, h = a.length;

        if (w * h ==0 || b < a[0][0] || b > a[h - 1][w - 1]) {
            return false;
        }

        int i = 0, j = w - 1;
        while (i < h && j != -1) {
            if (b > a[i][j]) {
                i++;
            } else if (b < a[i][j]) {
                j--;
            } else {
                return true;
            }

        }


        return false;
    }
    
}

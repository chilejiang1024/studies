package main.algorithm.a.jian.zhi.offer;

import java.time.LocalTime;

/**
 * Title : main.algorithm.a.jian.zhi.offer <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/2/26 18:32
 */
public class Clock {

    public static void main(String[] args) throws Exception {

        int[][] matrix = new int[7][25];

        int[][] nn = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 } };
        int[][] ns = { { 0, 0 }, { 0, 0 }, { 0, 3 }, { 0, 0 }, { 0, 3 }, { 0, 0 }, { 0, 0 } };
        int[][] n0 = { { 2, 2 }, { 1, 1 }, { 1, 1 }, { 0, 0 }, { 1, 1 }, { 1, 1 }, { 2, 2 } };
        int[][] n1 = { { 0, 0 }, { 0, 1 }, { 0, 1 }, { 0, 0 }, { 0, 1 }, { 0, 1 }, { 0, 0 } };
        int[][] n2 = { { 2, 2 }, { 0, 1 }, { 0, 1 }, { 2, 2 }, { 1, 0 }, { 1, 0 }, { 2, 2 } };
        int[][] n3 = { { 2, 2 }, { 0, 1 }, { 0, 1 }, { 2, 2 }, { 0, 1 }, { 0, 1 }, { 2, 2 } };
        int[][] n4 = { { 0, 0 }, { 1, 1 }, { 1, 1 }, { 2, 2 }, { 0, 1 }, { 0, 1 }, { 0, 0 } };
        int[][] n5 = { { 2, 2 }, { 1, 0 }, { 1, 0 }, { 2, 2 }, { 0, 1 }, { 0, 1 }, { 2, 2 } };
        int[][] n6 = { { 2, 2 }, { 1, 0 }, { 1, 0 }, { 2, 2 }, { 1, 1 }, { 1, 1 }, { 2, 2 } };
        int[][] n7 = { { 2, 2 }, { 0, 1 }, { 0, 1 }, { 0, 0 }, { 0, 1 }, { 0, 1 }, { 0, 0 } };
        int[][] n8 = { { 2, 2 }, { 1, 1 }, { 1, 1 }, { 2, 2 }, { 1, 1 }, { 1, 1 }, { 2, 2 } };
        int[][] n9 = { { 2, 2 }, { 1, 1 }, { 1, 1 }, { 2, 2 }, { 0, 1 }, { 0, 1 }, { 2, 2 } };

        int[][][] nb = {n0, n1, n2, n3, n4, n5, n6, n7, n8, n9};

        while (true) {
            LocalTime now = LocalTime.now();
            int hour = now.getHour();
            int mins = now.getMinute();
            int secd = now.getSecond();
            String timeStr = String.format("%2d%2d%2d", hour, mins, secd).replaceAll(" ", "0");
            System.out.println(timeStr);
            int loc = 0;
            for (int i = 0; i < timeStr.length(); i++) {
                add(matrix, nb[(int) timeStr.charAt(i) - 48], loc++);
                if (i > 0 && i % 2 == 1 && i != timeStr.length() - 1) {
                    add(matrix, ns, loc++);
                } else {
                    add(matrix, nn, loc++);
                }
            }
            print(matrix);
            Thread.sleep(1000);
        }
    }

    private static void add(int[][] matrix, int[][] number, int loc) {
        for (int i = 0; i < number.length; i++) {
            int[] t = number[i];
            matrix[i][loc * 2] = t[0];
            matrix[i][loc * 2 + 1] = t[1];
        }
    }

    private static void print(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int i : ints) {
                // System.out.print(i);
                switch (i) {
                    case 1:
                        System.out.print("|");
                        break;
                    case 2:
                        System.out.print("-");
                        break;
                    case 3:
                        System.out.print("*");
                        break;
                    default:
                        System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}

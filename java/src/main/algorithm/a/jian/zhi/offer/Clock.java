package main.algorithm.a.jian.zhi.offer;

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

    public static void main(String[] args) {

        int[][] marix = new int[5][6];

        int[][] one = { { 0, 0 }, { 0, 1 }, { 0, 1 }, { 0, 0 }, { 0, 1 }, { 0, 1 }, { 0, 0 } };

        print(one);
    }

    private static void print(int[][] marix) {
        for (int[] ints : marix) {
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

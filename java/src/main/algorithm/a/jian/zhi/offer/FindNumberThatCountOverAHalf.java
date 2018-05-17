package main.algorithm.a.jian.zhi.offer;

/**
 * Title : main.algorithm.a.jian.zhi.offer <br>
 * Description :
 *
 *   数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *   例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *   由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * @author chile
 * @version 1.0
 * @date 2018/5/17 10:35
 */
public class FindNumberThatCountOverAHalf {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNum(array));
    }

    /**
     * 守擂法
     * 设index为0处数字为擂主, 挑战者与擂主战力值等同, 坚持到最后者为出现次数最多之数
     * time complexity : O(n)
     * @param array
     * @return
     */
    private static int moreThanHalfNum(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int theNum = array[0], weight = 1, count = 0;
        for (int i = 1; i < array.length; i++) {
            if (theNum == array[i]) {
                weight++;
            } else {
                if (--weight == -1) {
                    theNum = array[i];
                    weight++;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == theNum) {
                count++;
            }
        }

        if (count > array.length / 2) {
            return theNum;
        } else {
            return 0;
        }
    }

    private static int moreThanHalfNum_2(int[] array) {
        int n = array.length;

        if (n == 0) {
            return 0;
        }

        // 考虑对快排做一下变形, 在TC为O(nlogn)下搞定
        // 再说吧 .....

        return 0;
    }
}

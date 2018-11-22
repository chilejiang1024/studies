package main.algorithm.a.jian.zhi.offer;

import org.junit.Test;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Title : main.algorithm.a.jian.zhi.offer <br>
 * Description : <br>
 *
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5, 3}，那么对应的输出是第一个重复的数字 2。
 * 要求复杂度为 O(N) + O(1)，时间复杂度 O(N)，空间复杂度 O(1)。
 *
 * 因此不能使用排序的方法，也不能使用额外的标记数组。
 * 这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素放到第 i 个位置上。如果此时第 i 个位置上已经有值为 i , 那么 i 重复。
 *
 * reference : https://github.com/CyC2018/Interview-Notebook/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md
 *
 * @author chile
 * @version 1.0
 * @date 2018/4/10 16:39
 */
public class DuplicateNumber {

    public static void main(String[] args) {
        // n = 8
        int[] a = {2, 5, 6, 4, 3, 1, 0, 7};
        int b = findOneDuplicateNumber(a);
        out.println(Arrays.toString(a));
        out.println(b);
    }

    private static int findOneDuplicateNumber(int[] a) {
        int i = 0, t = 0, d = -1;
        int n = a.length;
        for (; i < n; i++) {
            if ((t = a[i]) != i) {
                if (t == a[t]) {
                    d = t;
                    break;
                }
                swap(a, i, t);
            }
        }
        return d;
    }

    private static void swap(int[] a, int i1, int i2) {
        int t = a[i1];
        a[i1] = a[i2];
        a[i2] = t;
    }

    @Test
    public void test() {
        int[][] a = {{2, 1, 6, 4, 3, 1, 0, 7},
                     {3, 5, 6, 4, 3, 1, 0, 7},
                     {2, 5, 6, 4, 3, 1, 1, 7},
                     {2, 1, 6, 4, 1, 1, 0, 7}};
        int z;
        int[] zz = {1, 3, 1, 1};

        for (int i = 0; i < a.length; i++) {
            z = findOneDuplicateNumber(a[i]);
            assert z == zz[i];
        }

    }

}

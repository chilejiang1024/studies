package main.algorithm.a.jian.zhi.offer;

import static java.lang.System.out;

public class FindTheSmallestNNumbers {

    public static void main(String[] args) {
        find();
    }

    private static void find() {
        int[] a = {1, 2, 5, 7, 9};
        int[] b = {1, 4, 6, 8, 9, 10, 17};
        int i = 0, j = 0;
        int n = 4;
        while (n != 0) {
            if (a[i] == b[j]) {
                out.print(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                out.print(a[i]);
                i++;
            } else {
                out.print(b[j]);
                j++;
            }
            n--;
        }

    }

}

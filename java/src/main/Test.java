package main;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

/**
 * Title : PACKAGE_NAME
 * Description :
 *  - 
 *  -  
 *
 * @author main.chile
 * @version 1.0
 * @date 2017/3/30 14:37
 */
public class Test {

    public static void main(String[] args) {

        test7();

    }

    private static void test1() {
        List<Map<String, String>> aa = new ArrayList<>();
        aa.add(new HashMap<String, String>() {{put("id", "asd");}});
        Optional<List<Map<String, String>>> aaa = Optional.ofNullable(aa);
        final List<String> shareIdss = new ArrayList<>();
        aaa.ifPresent(list -> shareIdss.addAll(list.stream().map(m -> m.get("id")).collect(Collectors.toList())));
        System.out.println(shareIdss);

        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            aList.add(i);
            bList.add(i);
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < aList.size(); i++) {
            aList.set(i, aList.get(i) + 1);
        }
        long b = System.currentTimeMillis();
        for (int i = 0, j = bList.size(); i < j; i++) {
            bList.set(i, bList.get(i) + 1);
        }
        long c = System.currentTimeMillis();

        System.out.println((b - a) + ", " + (c - b));
    }

    private static void test2() {
        Map<String, String> map = new HashMap<>(2);
        map.put("result", "aa");
        map.put("code", "123123");
        System.out.println(map.toString());

    }

    private static void test3() {
        HashMap<Object, Object> h1 = new HashMap<>(12);
        HashMap<Object, Object> h2 = new HashMap<>(20);
        System.out.println("- -");
    }

    private static void test4() {
        out.println( 7 % 4);
        out.println( 7 & 4);
        out.println(-7 % 4);
        out.println(-7 & 4);
    }

    private static void test5() {
        int a = Integer.MAX_VALUE; // 0x7fffffff  0111 1111 1111 1111 1111 1111 1111 1111
        out.println(a + 1 < a);
        out.println(a + 1);
    }

    private static int test6(int n) {
        int[] a = {1, 1, 2};
        if (n <= 3) {
            return a[n - 1];
        }
        while (n-- >= 3) {
            a[2] = a[0] + a[1];
            a[0] = a[1];
            a[1] = a[2];
        }
        return a[2];
    }

    private static void test7() {
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

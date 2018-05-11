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

    /**
     * find a number make a + 1 < a right
     */
    private static void test5() {
        // 0x7fffffff  ->  0111 1111 1111 1111 1111 1111 1111 1111
        int a = Integer.MAX_VALUE;
        out.println(a + 1 < a);
        out.println(a + 1);
    }

    private static int test6(int n) {
        return 0;
    }

    abstract class SomeClass {
        abstract void a();
    }

    private void test7() {
        SomeClass sc = new SomeClass() {
            @Override
            void a() {
                System.out.println("a");
            }
        };
        sc.a();

        Runnable run = () -> {
            // TODO Auto-generated method stub
            System.out.println(Thread.currentThread().getName());
            int count = 10;
            while (count-- != 0) {
                System.out.println(count);
            }
        };
        new Thread(run).start();
    }

    private void test8() {
        new A();
        class A {

        }
    }

    class A {

    }

    private static void test9() {

    }

    /**
     * the main method
     */
    public static void main(String[] args) {

        new Test().test7();

    }
}

class A {
    public static void main(String[] args) {

    }
}
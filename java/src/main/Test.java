package main;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.apache.commons.httpclient.HttpClient;
import sun.misc.BASE64Decoder;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.clearProperty;
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
        new A("1");
        class A {

        }
    }

    private static class A {
        String name;

        A(String name) {
            this.name = name;
        }
    }

    private static void test9(List<A> l) {
        l.get(0).name = "1";
    }

    private static void test10() {
        List<A> list = new ArrayList<>();
        list.add(new A("1"));
        list.add(new A("1"));
        list.add(new A("1"));
        list.add(new A("1"));
        list.add(new A("1"));

        List<A> subList = list.subList(2, 3);
        subList.forEach(a -> a.name = "2");
        subList.isEmpty();

        list.forEach(a -> System.out.println(a.name));
    }

    private static void test11() {
        System.out.println(-8 >> 4);
        System.out.println( 4 >>> 2);
        System.out.println(0b10000000000000000000000000000001);
        System.out.println(Integer.toBinaryString(-1));
    }

    private static void test12() throws Exception {
        System.out.println(Class.forName("[[[[[[[J").getName());
    }

    @org.junit.Test
    public void test13() throws Exception {
        URL url = new URL("http://natas15.natas.labs.overthewire.org/index.php");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Basic bmF0YXMxNTpBd1dqMHc1Y3Z4clppT05nWjlKNXN0TlZrbXhkazM5Sg==");
        conn.setDoOutput(true);

    }

    @org.junit.Test
    public void test14() {
        int a = 1;
        switch (a) {
            case 0:
                System.out.println("a = 0");
                break;
            case 1:
                System.out.println("a = 1");
            case 2:
                System.out.println("a = 2");
        }

    }

    @org.junit.Test
    public void test15() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        int[] factor = new int[] { 2 };
        Stream<Integer> stream = numbers.stream()
                                        .peek(e -> System.out.println(factor[0]))
                                        .map(e -> e * factor[0]);

        factor[0] = 0;

        // stream.forEach(System.out::println);
        System.out.println(factor[0]);
    }

    @org.junit.Test
    public void test16() {
        Runnable runnable = () -> System.out.println("runnable");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(runnable);
        executorService.shutdown();
    }

    /**
     * the main method
     */
    public static void main(String[] args) throws Exception {

        System.out.println(int.class);

    }











}
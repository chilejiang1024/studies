package main;

import java.util.*;
import java.util.stream.Collectors;

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

        test2();

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
}

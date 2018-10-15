package main.java8.tricks;

import java.util.StringJoiner;

/**
 * Title : main.java8.tricks <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/10/15 11:00
 */
public class CombineStrings {

    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner(",");
        joiner.add("zhang1");
        joiner.add("zhang2");
        joiner.add("zhang3");
        joiner.add("zhang4");
        System.out.println(joiner.toString());
    }

}

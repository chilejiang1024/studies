package main.java.basics.lambda;

import java.util.function.Function;

/**
 * Title : main.java.basics <br />
 * Description :
 *  <p>
 *  <ul> 
 *    <li>  </li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/1/12 13:38
 */

public class JavaUtilFunctionalInterface {

    public static void main(String[] args) {
        Function<String, Integer> appendStringFunction = (String a) -> {
            System.out.println(a);
            return 0;
        };
        appendStringFunction.apply("sha bi.");
    }

}

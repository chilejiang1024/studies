package main.java8.tricks;

import java.util.Objects;

import static java.lang.System.out;

/**
 * Title : main.java8.tricks <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/3/29 9:35
 */
public class Equals {

    public static void main(String[] args) {
        Object a = "aaa";
        Object b = 123;

        out.println(Objects.equals(a, b));
    }





}

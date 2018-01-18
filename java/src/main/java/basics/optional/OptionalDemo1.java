package main.java.basics.optional;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * Title : main.java.basics.optional </br>
 * Description :
 *  <p>
 *  <ul> 
 *    <li>  </li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/1/18 17:43
 */
public class OptionalDemo1 {

    static class Human {
        String name;
        int    age;

        Human(String name, int age) {
            this.name = name;
            this.age  = age;
        }
    }

    public static void main(String[] args) {

        // 1 : prepare origin data
        Human h1 = null;
        Human h2 = null;

        h1 = new Human("zhuzhu", 24);

        // 2 : package `h1` `h2` with Optional container
        Optional<Human> optionalH1 = Optional.of(h1);
        Optional<Human> optionalH2 = Optional.ofNullable(h2);









    }

}

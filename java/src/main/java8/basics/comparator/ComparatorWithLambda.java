package main.java.basics.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Title : main.java.basics.lambda.comparator
 * Description :
 *  <p>
 *  <ul> 
 *    <li>  </li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/1/15 10:08
 */

public class ComparatorWithLambda {

    public static void main(String[] args) {

        List<Human> humans = new ArrayList<Human>() {{
            add(new Human("bbb", 13));
            add(new Human("bbb", 15));
            add(new Human("aaa", 12));
            add(new Human("ccc", 10));
        }};

        humans.forEach(System.out::println);
        humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
        humans.forEach(System.out::println);
    }


}


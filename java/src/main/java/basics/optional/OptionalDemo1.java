package main.java.basics.optional;

import java.util.Optional;

/**
 * Title : main.java.basics.optional <br>
 * Description :
 *  <p> {@link Optional} methods
 *  <ul> 
 *      <li> usage
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

        @Override
        public String toString() {
            return name + age;
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

        // 3 : methods
        // isPresent()
        p(optionalH1.isPresent());
        p(optionalH2.isPresent());

        // get()
        try {
            p(optionalH1.get());
            p(optionalH2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ifPresent()
        optionalH1.ifPresent(human -> p(human.toString()));
        optionalH2.ifPresent(human -> p(human.toString()));

        // orElse()
        optionalH1.orElse(new Human("dandan", 18));
        optionalH2.orElse(new Human("dandan", 18));

        // orElseGet()
        optionalH1.orElseGet(() -> new Human("huahua", 19));
        optionalH2.orElseGet(() -> new Human("huahua", 19));

        // orElseThrow()
        optionalH1.orElseThrow(() -> new RuntimeException("no such element."));
        optionalH2.orElseThrow(() -> new RuntimeException("no such element."));

        // map()
        optionalH1.map(human -> human.name);
        optionalH2.map(human -> human.name);

        // flatMap()
        optionalH1.flatMap(human -> Optional.of(human.name));
        optionalH2.flatMap(human -> Optional.of(human.name));

        // filter()
        optionalH1.filter(human -> human.age > 18);
        optionalH2.filter(human -> human.age > 18);
    }

    private static void p(Object o) {
        System.out.println(o);
    }

}

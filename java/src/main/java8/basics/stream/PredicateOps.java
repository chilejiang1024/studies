package main.java8.basics.stream;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Title : main.java8.basics.stream <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2020/5/11 10:47
 */
public class PredicateOps {

    private static class Apple {

        private int color;
        private int weight;

        public Apple(int color, int weight) {
            this.color = color;
            this.weight = weight;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("color: %d, weight: %d", this.color, this.weight);
        }

    }

    private static List<Apple> APPLES = new ArrayList<>();

    static {
        APPLES.add(new Apple(1, 10));
        APPLES.add(new Apple(2, 20));
        APPLES.add(new Apple(3, 30));
        APPLES.add(new Apple(4, 40));
        APPLES.add(new Apple(5, 50));
    }

    private List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate) {
        Objects.requireNonNull(predicate);
        List<Apple> result = new ArrayList<>();
        if (CollectionUtils.isEmpty(apples)) {
            return result;
        }
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    @Test
    public void test1() {
        filterApples(APPLES, (apple) -> apple.color > 2)
                .forEach(apple -> System.out.println(apple.toString()));
    }

    @Test
    public void test2() {
        filterApples(APPLES, (apple) -> apple.weight > 20)
                .forEach(apple -> System.out.println(apple.toString()));
    }

}

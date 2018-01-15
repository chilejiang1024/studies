package main.java.basics.lambda.comparator;

/**
 * Title : main.java.basics.lambda.comparator
 * Description :
 *  <p>
 *  <ul> 
 *    <li>  </li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/1/15 10:10
 */

public class Human {

    private String name;

    private int age;

    /**
     * setters and getters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    Human(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    @Override
    public String toString() {
        return String.format("%s, %d.", this.name, this.age);
    }
}

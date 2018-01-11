package main.java.basics;

/**
 * Title : java.basics
 * Description :
 * <p> lambda basics
 * <ul>
 * <li>
 * </ul>
 *
 * @author chile
 * @version 1.0
 * @date 23/12/2017
 */

public class Lambda {

    /**
     * filter
     */
    private static void function1() {
        String regex = "[\u4e00-\u9fff]";
        System.out.println(" 嘿嘿啥嘿 ".split(regex).length - 1);
    }


    public static void main(String[] args) {
        function1();
    }
}

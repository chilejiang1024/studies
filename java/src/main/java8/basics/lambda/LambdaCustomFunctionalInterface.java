package main.java.basics.lambda;

/**
 * Title : java.basics
 * Description :
 * <p> lambda basics
 * <ul>
 * <li> LambdaCustomFunctionalInterface
 * </ul>
 *
 * @author chile
 * @version 1.0
 * @date 23/12/2017
 */

public class LambdaCustomFunctionalInterface {

    interface MyLambdaFunctionalInterface {
        /**
         * perform the function
         */
        void perform();
    }

    private static void function1() {
        MyLambdaFunctionalInterface greeter = () -> System.out.println("hello");
        run(greeter);
    }
    
    private static void run(MyLambdaFunctionalInterface lambda) {
        System.out.println(lambda);
        lambda.perform();
    }
    
    public static void main(String[] args) {
        function1();
    }
}

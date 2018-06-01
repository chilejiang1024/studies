package main.java8.basics.concurrent.sync.on_static_method;

/**
 * Title : main.java8.basics.concurrent.sync <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/5/30 17:13
 */
public class ClassB {

    public static void main(String[] args) {

        new Thread(() -> ClassA.synchronizedMethod1()).start();

        new Thread(() -> ClassA.method2()).start();

        new Thread(() -> ClassA.method3()).start();
    }

}

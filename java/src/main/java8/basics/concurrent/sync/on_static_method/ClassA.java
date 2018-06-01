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
 * @date 2018/5/30 17:12
 */
class ClassA {

    static synchronized void synchronizedMethod1() {
        System.out.println(1);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void method2() {
        System.out.println(2);
    }

    /**
     * the same as {@link #synchronizedMethod1()}
     */
    static void method3() {
        synchronized (ClassA.class) {
            System.out.println(3);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

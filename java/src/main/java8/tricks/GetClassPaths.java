package main.java8.tricks;

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
 * @date 2018/4/8 13:36
 */
public class GetClassPaths {

    public static void main(String[] args) {

        // ---> /Z:/work/jiang-intellij-workspace/codes/java/target/classes/
        out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());

        // ---> java.lang.NullPointerException
        // out.println(Thread.currentThread().getContextClassLoader().getResource("/").getPath());




    }


}

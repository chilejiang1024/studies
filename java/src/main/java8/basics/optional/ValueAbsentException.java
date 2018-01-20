package main.java.basics.optional;

/**
 * Title : main.java.basics.optional </br>
 * Description : </br>
 *  <p>
 *  <ul> 
 *    <li>  </li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/1/18 14:53
 */
public class ValueAbsentException extends Exception {
    ValueAbsentException() {
        super();
        System.out.println("Value absent.");
    }

    ValueAbsentException(String msg) {
        super(msg);
        System.out.println("Value absent.");
    }

    @Override
    public String getMessage() {
        return "No value present in the Optional instance";
    }
}

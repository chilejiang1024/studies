package main.java8.basics.proxy.jdk;

/**
 * Title : main.java8.basics.proxy.jdk <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2020/11/26 10:22
 */
public class PrintServiceImpl implements IPrintService {

    @Override
    public void print(Object o) {
        System.out.println(o);
    }

}

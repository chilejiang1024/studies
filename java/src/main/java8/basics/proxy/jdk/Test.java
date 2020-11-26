package main.java8.basics.proxy.jdk;

/**
 * Title : main.java8.basics.proxy.jdk <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2020/11/26 10:30
 */
public class Test {

    public static void main(String[] args) {
        IPrintService printService = (IPrintService) SystemProxyFactory.getProxyInstance(new PrintServiceImpl());
        printService.print("aoooo");
    }

}

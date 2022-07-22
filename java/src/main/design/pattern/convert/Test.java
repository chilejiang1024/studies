package main.design.pattern.convert;

/**
 * Description :
 * <br>
 * <br>
 *
 * @author zhili
 * @version 1.0
 * @date 2022/7/13 15:01
 */
public class Test {

    @org.junit.Test
    public void test1() {
        Order order = new Order();
        order.id = "123";
        System.out.println(order.convertToDTO().id);
    }

}

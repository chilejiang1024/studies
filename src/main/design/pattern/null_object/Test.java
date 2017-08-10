package main.design.pattern.null_object;

/**
 * Title : main.design.pattern.null_object
 * Company : 北京华宇元典信息服务有限公司
 * Description :
 *  - 测试类
 *  -  
 *
 * @author chile
 * @version 1.0
 * @date 2017/8/10 11:20
 */

public class Test {

    public static void main(String[] args) {
        Book book = BookFactory.getBook("1");
        book.showInfo();
    }

}

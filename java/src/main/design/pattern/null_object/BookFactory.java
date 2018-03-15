package main.design.pattern.null_object;

/**
 * Title : main.design.pattern.null_object
 * Company : 北京华宇元典信息服务有限公司
 * Description :
 *  - 工厂类
 *  - 根据id, 返回book对象
 *
 * @author chile
 * @version 1.0
 * @date 2017/8/10 11:17
 */

class BookFactory {

    static Book getBook(String id) {
        Book book;
        switch (id) {
            case "1" :
                book = new ConcreteBook("1", "11111111");
                break;
            case "2" :
                book = new ConcreteBook("2", "22222222");
                break;
            default :
                book = new NullBook();
                break;
        }
        return book;
    }

}

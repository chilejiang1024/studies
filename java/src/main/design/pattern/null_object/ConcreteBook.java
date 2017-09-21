package main.design.pattern.null_object;

/**
 * Title : main.design.pattern.null_object
 * Company : 北京华宇元典信息服务有限公司
 * Description :
 *  - 真正查到的book
 *  -  
 *
 * @author chile
 * @version 1.0
 * @date 2017/8/10 11:14
 */

public class ConcreteBook implements Book {

    private String id;
    private String name;

    public ConcreteBook(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public void showInfo() {
        System.out.println("id : " + id + " name : " + name);
    }
}

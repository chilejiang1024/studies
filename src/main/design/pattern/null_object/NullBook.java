package main.design.pattern.null_object;

/**
 * Title : main.design.pattern.null_object
 * Company : 北京华宇元典信息服务有限公司
 * Description :
 *  - 未查询到返回的 null book
 *  -  
 *
 * @author chile
 * @version 1.0
 * @date 2017/8/10 11:12
 */

public class NullBook implements Book {

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public void showInfo() {
        System.out.println("未查到任何数据.");
    }
}

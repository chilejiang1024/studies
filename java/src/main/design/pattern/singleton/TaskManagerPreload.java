package main.design.pattern.singleton;

/**
 * Title : main.design.pattern.singleton <br>
 * Description :
 *  <p> singleton INSTANCE
 *  <ul> 
 *      <li> 恶汉式单例, 天生线程安全.
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/1/22 18:28
 */
public class TaskManagerPreload {

    private static final TaskManagerPreload INSTANCE = new TaskManagerPreload();

    private TaskManagerPreload() {}

    public static TaskManagerPreload getInstance() {
        return INSTANCE;
    }
}

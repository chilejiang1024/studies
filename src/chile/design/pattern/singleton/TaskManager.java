package chile.design.pattern.singleton;

/**
 * Title : chile.design.pattern.singleton
 * Description :
 *  - 单例模式有三个要点  一是某个类只能有一个实例
 *                      二是它必须自行创建这个实例
 *                      三是它必须自行向整个系统提供这个实例
 *  -  
 *
 * @author chile
 * @version 1.0
 * @date 2017/3/31 10:28
 */

public class TaskManager {

    private static TaskManager tm = null;

    private TaskManager() {}

    // -----------------------------------------------------------------------------------------------------------------
    /**
     * get singleton instance
     *
     * @return tm
     */
    public static TaskManager getInstance() {
        if (tm == null) {
            tm = new TaskManager();
        }
        return tm;
    }
    // -----------------------------------------------------------------------------------------------------------------

    public void displayProcesses() {}

    public void displayServices() {}

}

package main.design.pattern.singleton;

/**
 * Title : main.design.pattern.singleton <br>
 * Description : <br>
 *  - 单例模式有三个要点  一是某个类只能有一个实例
 *                      二是它必须自行创建这个实例
 *                      三是它必须自行向整个系统提供这个实例
 *  懒汉式(懒加载)单例的实现
 *
 * @author main.chile
 * @version 1.0
 * @date 2017/3/31 10:28
 */

public class TaskManager {

    private static TaskManager tm = null;

    private TaskManager() {}

    // -----------------------------------------------------------------------------------------------------------------
    /**
     * 1
     * get singleton instance
     * very not good, not safe
     * @return tm
     */
    public static TaskManager getInstance() {
        if (tm == null) {
            tm = new TaskManager();
        }
        return tm;
    }

    /**
     * 2
     * get singleton instance
     * @return tm
     */
    public static synchronized TaskManager getInstanceSynchronizedMethod() {
        if (tm == null) {
            tm = new TaskManager();
        }
        return tm;
    }

    /**
     * 3
     * get singleton instance synchronized
     * better than {@link #getInstanceSynchronizedMethod()}
     * @return tm
     */
    public static TaskManager getInstanceSynchronized() {
        if (null == tm) {
            synchronized (TaskManager.class) {
                if (null == tm) {
                    tm = new TaskManager();
                }
            }
        }
        return tm;
    }


    private static class InstanceHolder {
        private static final TaskManager INSTANCE = new TaskManager();
    }

    /**
     * 4
     * get singleton instance with inner static class
     * @return tm
     */
    public static TaskManager getInstanceWithInnerStaticClass() {
        return InstanceHolder.INSTANCE;
    }
    // -----------------------------------------------------------------------------------------------------------------

    public void displayProcesses() {}

    public void displayServices() {}

}

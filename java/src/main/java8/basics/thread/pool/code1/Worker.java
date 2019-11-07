package main.java8.basics.thread.pool.code1;

import java.util.concurrent.BlockingQueue;

/**
 * Title : main.java8.basics.thread.study.pool <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/11/7 11:04
 */
public class Worker implements Runnable {

    private Thread thread;
    private Runnable task;
    private BlockingQueue<Runnable> taskQueue;

    public Worker(BlockingQueue<Runnable> taskQueue) {
        this.thread = new Thread(this);
        this.taskQueue = taskQueue;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see     Thread#run()
     */
    @Override
    public void run() {
        try {
            while (true) {
                task = taskQueue.take();
                task.run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        this.thread.start();
    }
}

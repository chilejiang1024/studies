package main.java8.basics.thread.pool.code1;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Title : main.java8.basics.thread.study.pool <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/11/7 11:09
 */
public class WorkerTests {

    public static void main(String[] args) {
        BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<Runnable>(100);
        Worker worker = new Worker(taskQueue);
        worker.start();
        for (int i = 0; i < 100; i++) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    System.out.println(new Date());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            taskQueue.add(r);
        }
    }

}

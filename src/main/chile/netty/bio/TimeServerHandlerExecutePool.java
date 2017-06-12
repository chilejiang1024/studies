package main.chile.netty.bio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2017/3/6.
 * by main.chile.
 * function :
 */

public class TimeServerHandlerExecutePool {

    private ExecutorService executor;

    /**
     *
     * @param maxPoolSize
     * @param queueSize
     */
    public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        executor = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                maxPoolSize,
                120L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<java.lang.Runnable>(queueSize));

    }

    public void execute(java.lang.Runnable task) {
        executor.execute(task);
    }


}

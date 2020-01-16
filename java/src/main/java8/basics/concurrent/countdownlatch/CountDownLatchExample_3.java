package main.java8.basics.concurrent.countdownlatch;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Title : main.java8.basics.concurrent.countdownlatch <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/2/28 14:30
 */
public class CountDownLatchExample_3 {

    private static final AtomicInteger THREAD_ORDER = new AtomicInteger(0);

    private static final ArrayList<String> list = new ArrayList<>();

    private static final ThreadPoolExecutor EXECUTOR;

    static {
        int cores = Runtime.getRuntime().availableProcessors();
        EXECUTOR = new ThreadPoolExecutor(cores, cores + 1, 120, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1024), new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable r) {
                Thread t = new Thread(r);
                t.setName(String.format("my-thread-%d", THREAD_ORDER.addAndGet(1)));
                return t;
            }
        });
    }



    static class DownloadService {

        private CountDownLatch latch;

        public DownloadService(CountDownLatch latch) {
            this.latch = latch;
        }

        public void download(int index) {
            for (int i = 0; i < 10; i++) {
                list.add(Thread.currentThread().getName());
                System.out.println("downloading ... , left: " + latch.getCount() + ", thread is: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        int downloadCount = 100;

        list.forEach(System.out::print);
        System.out.println();

        CountDownLatch latch = new CountDownLatch(downloadCount);

        DownloadService downloadService = new DownloadService(latch);

        for (int i = 0; i < 10; i++) {
            final int batch = i;
            Runnable task = () -> downloadService.download(batch);
            EXECUTOR.submit(task);
        }
        latch.await();
        System.out.println("download task done, count: " + list.size());
        System.out.println("total time: " + (System.currentTimeMillis() - start) + "ms.");


        EXECUTOR.shutdown();
    }

}

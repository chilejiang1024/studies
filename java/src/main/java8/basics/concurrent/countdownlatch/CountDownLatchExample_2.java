package main.java8.basics.concurrent.countdownlatch;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * Title : main.java8.basics.concurrent.countdownlatch <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/2/28 14:30
 */
public class CountDownLatchExample_2 {

    private static ArrayList<String> intList = new ArrayList<>();

    static class DownloadService {

        private CountDownLatch latch;

        public DownloadService(CountDownLatch latch) {
            this.latch = latch;
        }

        public void download(int index) {
            for (int i = 0; i < 10; i++) {
                intList.add(Thread.currentThread().getName().substring(18, 19));
                latch.countDown();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        int downloadCount = 100;

        intList.forEach(System.out::print);
        System.out.println();

        CountDownLatch latch = new CountDownLatch(downloadCount);
        DownloadService downloadService = new DownloadService(latch);

        for (int i = 0; i < 10; i++) {
            final int batch = i;
            Runnable task = () -> downloadService.download(batch);
            Thread t = new Thread(task);
            t.setName("Download thread - " + i);
            t.start();
        }
        latch.await();
        intList.forEach(System.out::print);

    }

}

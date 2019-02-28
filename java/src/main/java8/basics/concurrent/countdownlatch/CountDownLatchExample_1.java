package main.java8.basics.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Title : main.java8.basics.concurrent.countdownlatch <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2019/2/28 13:57
 */
public class CountDownLatchExample_1 {

    static class Service {

        private CountDownLatch latch;

        public Service(CountDownLatch latch) {
            this.latch = latch;
        }

        public void serve() {
            System.out.println("serving ... " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(5);

        Service service = new Service(latch);

        Runnable task = service::serve;

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task);
            thread.setName("Service thread - " + i);
            thread.start();
        }

        System.out.println("awaiting ...");

        latch.await();

        System.out.println("awaiting done ...");

    }

}

package main.java8.basics.thread.concurrent.semaphore;

/**
 * Title : main.java8.basics.thread.concurrent.semaphore <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/6/12 14:09
 */
public class ReceivingThread implements Runnable {

    private Semaphore semaphore;

    ReceivingThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.semaphore.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " do something.");
            sleep(1000);
        }
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

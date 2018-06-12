package main.java8.basics.thread.concurrent.semaphore;

/**
 * Title : main.java8.basics.thread.concurrent.semaphore <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/6/12 14:02
 */
public class SendingThread implements Runnable {

    private Semaphore semaphore;

    SendingThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " do something.");
            sleep(1000);
            this.semaphore.release();
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

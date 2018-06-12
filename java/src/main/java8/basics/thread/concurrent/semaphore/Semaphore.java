package main.java8.basics.thread.concurrent.semaphore;

/**
 * Title : main.java8.basics.thread.concurrent.semaphore <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/6/12 13:51
 */
public class Semaphore {

    private boolean signal = false;

    public synchronized void release() {
        System.out.println("Semaphore will notify ...");
        this.signal = true;
        notify();
    }

    public synchronized void take() throws InterruptedException {
        while (!this.signal) {
            System.out.println("Not receiving signal, so thread will wait ...");
            wait();
        }
        this.signal = false;
    }

}

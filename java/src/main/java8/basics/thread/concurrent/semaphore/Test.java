package main.java8.basics.thread.concurrent.semaphore;

/**
 * Title : main.java8.basics.thread.concurrent.semaphore <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/6/12 14:11
 */
public class Test {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore();

        Thread s = new Thread(new SendingThread(semaphore));
        Thread r = new Thread(new ReceivingThread(semaphore));

        s.setName("thread-s");
        r.setName("thread-r");

        r.start();
        s.start();
    }

}

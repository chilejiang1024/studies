package main.java8.basics.thread;

/**
 * Title : main.java8.basics.thread <br>
 * Description :
 *   wait and notify
 *
 * @author chile
 * @version 1.0
 * @date 2018/5/8 18:01
 */
public class WaitAndNotify {

    static class MyRunnable implements Runnable {

        String   str;

        MyRunnable(String str) {
            this.str = str;
        }

        @Override
        public void run() {
            System.out.println("run ... (@" + Thread.currentThread().getName() + ")");
            synchronized (this) {
                try {
                    System.out.println("wait ... (@" + Thread.currentThread().getName() + ")");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int count = 10;
            while (count > 0) {
                System.out.print(str);
                count--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable r1 = new MyRunnable("A");
        MyRunnable r2 = new MyRunnable("B");
        MyRunnable r3 = new MyRunnable("C");
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        t1.setName("thread-1");
        t2.setName("thread-2");
        t3.setName("thread-3");

        t1.start();

        Thread.sleep(2000);

        synchronized (r1) {
            System.out.println("notify ... (@" + Thread.currentThread().getName() + ")");
            r1.notify();
            // Once a thread is awakened it cannot exit the wait() call until the thread calling notify() has left its synchronized block.
            System.out.println("after 2s ...");
            Thread.sleep(2000);
        }
    }

}


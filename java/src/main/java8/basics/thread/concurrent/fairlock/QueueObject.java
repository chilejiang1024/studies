package main.java8.basics.thread.concurrent.fairlock;

/**
 * Title : main.java8.basics.thread.concurrent.fairlock <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/6/8 16:56
 */
public class QueueObject {

    private boolean isNotified = false;

    public synchronized void doWait() throws InterruptedException {

        while(!isNotified){
            this.wait();
        }

        this.isNotified = false;

    }

    public synchronized void doNotify() {
        this.isNotified = true;
        this.notify();
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

}


package main.algorithm.leetcode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2020/11/19 14:56
 */
public class PrintFooBarAlternately {

    private static Logger logger = LoggerFactory.getLogger(PrintFooBarAlternately.class);

    static class FooBar {

        private int n;

        private final Object LOCK = new Object();

        private AtomicInteger flag;

        public FooBar(int n) {
            this.n = n;
            this.flag = new AtomicInteger(0);
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (LOCK) {
                    if (flag.get() != 0) {
                        LOCK.wait();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    flag.set(1);
                    LOCK.notifyAll();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (LOCK) {
                    if (flag.get() != 1) {
                        LOCK.wait();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    flag.set(0);
                    LOCK.notifyAll();
                }
            }
        }
    }

    @Test
    public void test() throws InterruptedException{
        FooBar fb = new FooBar(3);

        Thread t1 = new Thread(() -> {
            try {
                fb.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fb.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(1000);
    }
}

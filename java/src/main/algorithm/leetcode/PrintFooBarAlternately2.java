package main.algorithm.leetcode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2020/11/19 14:56
 */
public class PrintFooBarAlternately2 {

    private static Logger logger = LoggerFactory.getLogger(PrintFooBarAlternately2.class);

    static class FooBar {

        private int n;

        private Semaphore foo;
        private Semaphore bar;

        public FooBar(int n) {
            this.n = n;
            foo = new Semaphore(1);
            bar = new Semaphore(0);
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                foo.acquire();
                printFoo.run();
                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                bar.acquire();
                printBar.run();
                foo.release();
            }
        }
    }

    @Test
    public void test() throws InterruptedException {
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

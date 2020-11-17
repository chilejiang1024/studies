package main.algorithm.leetcode;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Title : main.algorithm.leetcode <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2020/11/17 15:43
 */
public class PrintInOrder {

    static class Foo {

        private AtomicInteger cond;

        private final Object lock;

        public Foo() {
            cond = new AtomicInteger(0);
            lock = new Object();
        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (lock) {
                while (cond.get() != 0) {
                    lock.wait();
                }
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                cond.set(1);
                lock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (cond.get() != 1) {
                    lock.wait();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                cond.set(2);
                lock.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (cond.get() != 2) {
                    lock.wait();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                cond.set(3);
                lock.notifyAll();
            }
        }
    }

    @Test
    public void test() throws InterruptedException {
        Runnable r1 = () -> System.out.println("first");
        Runnable r2 = () -> System.out.println("second");
        Runnable r3 = () -> System.out.println("third");
        Foo foo = new Foo();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        Runnable task1 = () -> {
            try {
                foo.first(r1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable task2 = () -> {
            try {
                foo.second(r2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable task3 = () -> {
            try {
                foo.third(r3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
    }

}

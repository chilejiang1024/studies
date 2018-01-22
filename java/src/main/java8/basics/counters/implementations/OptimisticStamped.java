package main.java8.basics.counters.implementations;

import main.java8.basics.counters.Counter;

import java.util.concurrent.locks.StampedLock;

public class OptimisticStamped implements Counter {

    private StampedLock rwlock = new StampedLock();

    private long counter;

    private long success;

    private long total;

    @Override
    public long getCounter() {
        long stamp = rwlock.tryOptimisticRead();

        total++;

        if (rwlock.validate(stamp)) {
            success++;
            return counter;
        }

        return counter;

    }

    @Override
    public void increment() {
        long stamp = rwlock.writeLock();

        try {
            ++counter;
        } finally {
            rwlock.unlockWrite(stamp);
        }
    }

    public long getSuccess() {
        return success;
    }

    public long getTotal() {
        return total;
    }
}

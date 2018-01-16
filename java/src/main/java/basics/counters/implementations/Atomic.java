package main.java.basics.counters.implementations;

import java.util.concurrent.atomic.AtomicLong;

import main.java.basics.counters.Counter;

public class Atomic implements Counter {

    private final AtomicLong atomic = new AtomicLong();

    @Override
    public long getCounter() {
        return atomic.get();
    }

    @Override
    public void increment() {
        atomic.incrementAndGet();
    }
}

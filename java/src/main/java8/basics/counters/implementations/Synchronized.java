package main.java.basics.counters.implementations;

import main.java.basics.counters.Counter;

public class Synchronized implements Counter {

    private Object lock = new Object();

    private int counter;

    @Override
    public long getCounter() {
        synchronized (lock) {
            return counter;
        }
    }

    @Override
    public void increment() {
        synchronized (lock) {
            ++counter;
        }
    }
}

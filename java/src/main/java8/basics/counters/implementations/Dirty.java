package main.java.basics.counters.implementations;

import main.java.basics.counters.Counter;

public class Dirty implements Counter {

    private long counter;

    @Override
    public long getCounter() {
        return counter;
    }

    @Override
    public void increment() {
        ++counter;
    }
}

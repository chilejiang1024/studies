package main.java8.basics.counters.implementations;

import main.java8.basics.counters.Counter;

import java.util.concurrent.atomic.LongAdder;

public class Adder implements Counter {

    private final LongAdder adder = new LongAdder();

    @Override
    public long getCounter() {
        return adder.longValue();
    }

    @Override
    public void increment() {
        adder.increment();
    }
}

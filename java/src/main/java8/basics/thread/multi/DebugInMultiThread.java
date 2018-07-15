package main.java8.basics.thread.multi;

public class DebugInMultiThread {


    /**
     * 使用调到下一个断点调试才能够进入, 不能使用下一步.
     */
    private static void method1() {
        System.out.println("method1");
    }

    public static void main(String[] args) {
        System.out.println("main thread --- before");
        new Thread(() -> method1()).start();
        System.out.println("main thread --- after");
    }













}

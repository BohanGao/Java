package com.bohangao.AtomicVariable;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableDemo {
    public static void demo() throws InterruptedException {
        Thread thomas = new Thread(new Shopper());
        Thread ashley = new Thread(new Shopper());
        thomas.start();
        ashley.start();
        thomas.join();
        ashley.join();
        System.out.println("We should buy " + Shopper.garlicCount + " garlic.");
    }
}

class Shopper implements Runnable {

    static AtomicInteger garlicCount = new AtomicInteger(0);

    public void run() {
        for (int i=0; i<100000; i++){
            garlicCount.incrementAndGet();
        }
    }
}

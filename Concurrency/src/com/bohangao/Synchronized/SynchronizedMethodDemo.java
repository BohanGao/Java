package com.bohangao.Synchronized;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedMethodDemo {
    public static void demo() throws InterruptedException {
        Thread thomas = new Thread(new SynchronizedMethodShopper());
        Thread ashley = new Thread(new SynchronizedMethodShopper());
        thomas.start();
        ashley.start();
        thomas.join();
        ashley.join();
        System.out.println("We should buy " + SynchronizedMethodShopper.garlicCount + " garlic.");
    }
}

class SynchronizedMethodShopper implements Runnable {

    static int garlicCount = 0;

    private static synchronized void addGarlic(){
        garlicCount++;
    }

    public void run() {
        for (int i=0; i<100000; i++){
            addGarlic();
        }
    }
}

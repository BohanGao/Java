package com.bohangao.MutualExclusion;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutualExclusionDemo {
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

    static int garlicCount = 0;
    static Lock pencil = new ReentrantLock();

    public void run() {
        for (int i=0; i<100000; i++){
            pencil.lock();
            garlicCount++;
            pencil.unlock();
        }
    }
}

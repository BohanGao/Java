package com.bohangao.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void demo() throws InterruptedException {
        Thread thomas = new Thread(new Shopper());
        Thread ashley = new Thread(new Shopper());
        thomas.start();
        ashley.start();
        thomas.join();
        ashley.join();
        System.out.println("We should buy " + Shopper.garlicCount + " garlic.");
        System.out.println("We should buy " + Shopper.potatoCount + " potato.");
    }
}

class Shopper implements Runnable {

    static int garlicCount = 0;
    static int potatoCount = 0;
    static ReentrantLock pencil = new ReentrantLock(); //ReentrantLock has method to get lock hold count.
    //static Lock pencil = new ReentrantLock(); //this will not hang the thread like mutex in c++

    private void addGarlic() {
        pencil.lock();
        System.out.println("Hold count: " + pencil.getHoldCount());
        garlicCount++;
        pencil.unlock();
    }

    private void addPotatoDish() {
        pencil.lock();
        potatoCount++;
        addGarlic();
        pencil.unlock();
    }

    public void run() {
        for (int i=0; i<10000; i++){
            addGarlic();
            addPotatoDish();
        }
    }
}


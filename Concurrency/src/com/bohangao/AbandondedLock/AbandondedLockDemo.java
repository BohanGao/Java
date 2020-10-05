package com.bohangao.AbandondedLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AbandondedLockDemo {
    public static void demo() {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();
        Thread thomas = new Thread(new Philosopher("Thomas", chopstickA, chopstickB));
        Thread ashley = new Thread(new Philosopher("Ashley", chopstickB, chopstickC));
        Thread taro = new Thread(new Philosopher("Taro", chopstickA, chopstickC));
        thomas.start();
        ashley.start();
        taro.start();
        try{
            thomas.join();
            ashley.join();
            taro.join();
        }catch (InterruptedException iex){
            iex.printStackTrace();
        }
    }
}

class Philosopher implements Runnable {

    private String name;
    private Lock firstChopstick, secondChopstick;
    private static int sushiCount = 500;

    public Philosopher(String name, Lock firstChopstick, Lock secondChopstick) {
        this.name = name;
        this.firstChopstick = firstChopstick;
        this.secondChopstick = secondChopstick;
    }

    public void run() {
        while(sushiCount > 0) { // eat sushi until it's all gone

            // pick up chopsticks
            firstChopstick.lock();
            secondChopstick.lock();

            // take a piece of sushi
            if (sushiCount > 0) {
                sushiCount--;
                System.out.println(this.name + " took a piece! Sushi remaining: " + sushiCount);
            }

            if(sushiCount==10){
                System.out.println(1/0);
                //this will throw an exception, which cause locks never released, leads to abandonded lock.
                //use try catch block for the critical section, and release locks in the finally seciton.
            }

            // put down chopsticks
            secondChopstick.unlock();
            firstChopstick.unlock();
        }
    }
}

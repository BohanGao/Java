package com.bohangao.Starvation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StarvationDemo {
    public static void demo() {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();
        Thread thomas = new Thread(new Philosopher("Thomas", chopstickA, chopstickB));
        Thread ashley = new Thread(new Philosopher("Ashley", chopstickB, chopstickC));//thomas and taro are competing for A, and ashley will have more sushi with less competition
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
        //with only big amount of philosopher threads, some philosophers may end up with 0 sushi where some may have a lot more.
    }
}

class Philosopher implements Runnable {

    private String name;
    private Lock firstChopstick, secondChopstick;
    private static int sushiCount = 5000;

    public Philosopher(String name, Lock firstChopstick, Lock secondChopstick) {
        this.name = name;
        this.firstChopstick = firstChopstick;
        this.secondChopstick = secondChopstick;
    }

    public void run() {
        int sushiTaken = 0;
        while(sushiCount > 0) { // eat sushi until it's all gone

            // pick up chopsticks
            firstChopstick.lock();
            secondChopstick.lock();

            // take a piece of sushi
            if (sushiCount > 0) {
                sushiCount--;
                sushiTaken++;
                System.out.println(this.name + " took a piece! Sushi remaining: " + sushiCount);
            }

            // put down chopsticks
            secondChopstick.unlock();
            firstChopstick.unlock();
        }
        System.out.println(this.name+" took "+sushiTaken+" pieces of sushi.");
    }
}

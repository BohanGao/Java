package com.bohangao.LiveLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLockDemo {
    public static void demo() {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();
        Thread thomas = new Thread(new Philosopher("Thomas", chopstickA, chopstickB));
        Thread ashley = new Thread(new Philosopher("Ashley", chopstickB, chopstickC));
        Thread taro = new Thread(new Philosopher("Taro", chopstickC, chopstickA));
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
    private static int sushiCount = 5000;
    private Random rps;

    public Philosopher(String name, Lock firstChopstick, Lock secondChopstick) {
        this.name = name;
        this.firstChopstick = firstChopstick;
        this.secondChopstick = secondChopstick;
    }

    public void run() {
        while(sushiCount > 0) { // eat sushi until it's all gone

            // pick up chopsticks
            firstChopstick.lock();
            if(!secondChopstick.tryLock()){
                System.out.println(name+" could not acquire thier second chopstick. Releasing their first chopstick.");
                firstChopstick.unlock();
                try{
                    Thread.sleep(rps.nextInt(3));
                    //like yield in c++, rescheduling the thread to prevent live lock.
                } catch(InterruptedException iex){
                    iex.printStackTrace();
                }
            } else {
                // take a piece of sushi
                if (sushiCount > 0) {
                    sushiCount--;
                    System.out.println(this.name + " took a piece! Sushi remaining: " + sushiCount);
                }

                // put down chopsticks
                secondChopstick.unlock();
                firstChopstick.unlock();
            }




        }
    }
}

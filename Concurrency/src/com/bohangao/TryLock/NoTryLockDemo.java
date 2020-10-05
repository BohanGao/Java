package com.bohangao.TryLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NoTryLockDemo {
    public static void demo() throws InterruptedException {
        Thread thomas = new Thread(new NoTryLockShopper("Thomas"));
        Thread ashley = new Thread(new NoTryLockShopper("Ashley"));
        long start = System.currentTimeMillis();
        thomas.start();
        ashley.start();
        thomas.join();
        ashley.join();
        long finish = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (float)(finish - start)/1000 + " seconds");
    }
}

class NoTryLockShopper implements Runnable {

    private String name;
    private int itemsToRecord = 0;
    private static int itemsRecorded = 0;
    private static Lock pencil = new ReentrantLock();

    public NoTryLockShopper(String name){
        this.name = name;
    }

    public void run() {
        while(itemsRecorded <= 20){
            if((itemsToRecord)>0){
                try{
                    pencil.lock();
                    itemsRecorded += itemsToRecord;
                    System.out.println(name+" added " + itemsToRecord + " item(s) to notepad.");
                    itemsToRecord = 0;
                    Thread.sleep(300);//mimic writing
                } catch (InterruptedException iex){
                    iex.printStackTrace();
                } finally {
                    pencil.unlock();
                }
            } else {
                try{
                    Thread.sleep(100);//mimic searching
                    itemsToRecord++;
                    System.out.println(name+" found something to buy.");
                } catch (InterruptedException iex){
                    iex.printStackTrace();
                }
            }
        }
    }
}
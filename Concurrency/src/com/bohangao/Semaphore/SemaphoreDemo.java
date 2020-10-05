package com.bohangao.Semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class SemaphoreDemo {
    public static void demo() {
        List<Thread> phones = new ArrayList<>();
        for(int i=0;i<10;i++){
            Thread phone = new Thread(new CellPhone("Phone"+i));
            phones.add(phone);
            phone.start();
        }
        for(Thread phone:phones){
            try{
                phone.join();
            } catch (InterruptedException iex){
                iex.printStackTrace();
            }
        }
    }
}

class CellPhone implements Runnable {
    private static Semaphore charger = new Semaphore(4);//only have 4 chargers

    private String name;

    public CellPhone(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            charger.acquire();
            System.out.println(name + " is charging...");
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        } finally {
            System.out.println(name + " is DONE charging!");
            charger.release();
        }
    }
}

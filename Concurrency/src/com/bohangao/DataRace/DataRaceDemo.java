package com.bohangao.DataRace;

public class DataRaceDemo {
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

    public void run() {
        for (int i=0; i<100000; i++)
            garlicCount++;
    }
}
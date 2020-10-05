package com.bohangao.Synchronized;

public class SynchronizedStatementDemo {
    public static void demo() throws InterruptedException {
        Thread thomas = new Thread(new SynchronizedStatementShopper());
        Thread ashley = new Thread(new SynchronizedStatementShopper());
        thomas.start();
        ashley.start();
        thomas.join();
        ashley.join();
        System.out.println("We should buy " + SynchronizedStatementShopper.garlicCount + " garlic.");
    }
}

class SynchronizedStatementShopper implements Runnable {

    static int garlicCount = 0;

    private static synchronized void addGarlic(){
        synchronized (SynchronizedStatementShopper.class){
            garlicCount++;
        };
    }

    public void run() {
        for (int i=0; i<100000; i++){
            addGarlic();
        }
    }
}

//Every Java object has an intrinsic lock associated with it,
//a thread that needs exclusive access to an object's fields has to acquire that object's lock before accessing them, and then release that intrinsic lock when it's done.
//use "synchronized" to acquire the intrinsic lock.

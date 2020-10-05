package com.bohangao.DaemonThread;

public class DaemonThreadDemo {
    public static void demo() throws InterruptedException {
        Thread ashley = new Thread(new KitchenCleaner());
        ashley.setDaemon(true);
        ashley.start();

        System.out.println("Thomas is cooking...");
        Thread.sleep(600);
        System.out.println("Thomas is cooking...");
        Thread.sleep(600);
        System.out.println("Thomas is cooking...");

        //ashley.join();
    }
}

class KitchenCleaner implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("Ashley cleaned the kitchen");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}

//Daemon Thread (Java) == Detached Thread (C++)
//Without set daemon thread, manually exit while child thread still running will cause exception
//After set daemon thread, daemon thead will not prevent program from exiting. The daemon thead will run at the background. When JVM stops, daemon thread will be terminated abruptly, and does not have chance to clean up.
//setDaemon should be called before run the thread. daemon property will be inherited by the child threads.
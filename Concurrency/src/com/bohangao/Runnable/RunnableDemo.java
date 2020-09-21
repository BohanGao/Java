package com.bohangao.Runnable;

public class RunnableDemo {
    public static void demo() throws InterruptedException {
        System.out.println("Thomas requests Ashley's help.");
        Thread ashley = new Thread(new SausageCutter());
        System.out.println("Ashley state: " + ashley.getState());

        System.out.println("Thomas tells Ashley to start.");
        ashley.start();
        System.out.println("Ashley state: " + ashley.getState());

        System.out.println("Thomas continues cooking soup.");
        Thread.sleep(500);
        System.out.println("Ashley state: " + ashley.getState());

        System.out.println("Thomas patiently waits for Ashley to finish and join...");
        ashley.join();
        System.out.println("Ashley state: " + ashley.getState());

        System.out.println("Thomas and Ashley are both done.");
    }
}

class SausageCutter implements Runnable {
    @Override
    public void run() {
        System.out.println("Ashley starts cutting sausage.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Ashley is done cutting sausage.");
    }
}

//Thread class vs Runnable interface
//Extending Thread class, means no other class can be extended. Whereas Runnable is a interface, and a class can implement multiple interfaces. Runnable gives more flexibility.
//Each instance of Thread class is a separate object. Whereas multiple threads can share a single Runnable object. Runnable can save memory, however keep in mind that threads sharing the same Runnable object will use the same property value of this object.
//Overall Runnable is preferred.
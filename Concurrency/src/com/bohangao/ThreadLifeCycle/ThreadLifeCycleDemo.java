package com.bohangao.ThreadLifeCycle;

public class ThreadLifeCycleDemo {
    public static void demo() throws InterruptedException {
        System.out.println("Thomas requests Ashley's help.");
        Thread ashley = new SausageCutter();
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

class SausageCutter extends Thread {
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

//getState() - get state of a thread
//currentThread() - return current thread object
//getID() - get thread id of the current thread
//getName(), setName() - get and set the name of the thread
//getPriority(), setPriority() - get and set the priority of a thread, 1-10, 10 is highest

//Child thread does not have access to parent thread. this is for garbage collection purpose

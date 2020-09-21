package com.bohangao.ThreadProcess;

public class ThreadProcessDemo {
    public static void demo(){
        Runtime runtime = Runtime.getRuntime();
        long usedKB = (runtime.totalMemory() - runtime.freeMemory()) / 1024;
        System.out.format("Thread Count: %d\n", Thread.activeCount());
        System.out.format("Memory Usage: %d KB\n", usedKB);

        // start 6 new threads
        System.out.println("\nStarting 6 CPUWaster threads...\n");
        for (int i=0; i<6; i++)
            new CPUWaster().start();

        // display current information about this process
        usedKB = (runtime.totalMemory() - runtime.freeMemory()) / 1024 ;
        System.out.format("Thread Count: %d\n", Thread.activeCount());
        System.out.format("Memory Usage: %d KB\n", usedKB);

    }
}

class CPUWaster extends Thread {
    @Override
    public void run() {
        while(true){

        }
    }
}

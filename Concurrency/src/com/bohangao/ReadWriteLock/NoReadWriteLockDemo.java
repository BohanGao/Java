package com.bohangao.ReadWriteLock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class NoReadWriteLockDemo {
    public static void demo() {
        List<Thread> readers = new LinkedList<>();
        for (int i=0; i<10; i++){
            Thread thread = new Thread(new NoReadWriteLockCalendarUser("Reader-"+i));
            thread.start();
            readers.add(thread);
        }
        List<Thread> writers = new LinkedList<>();
        for (int i=0; i<2; i++){
            Thread thread = new Thread(new NoReadWriteLockCalendarUser("Writer-"+i));
            thread.start();
            writers.add(thread);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Thread thread:readers){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(Thread thread:writers){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class NoReadWriteLockCalendarUser implements Runnable {

    private String name;
    private static final String[] WEEKDAYS = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private static int today = 0;
    private static ReentrantLock marker = new ReentrantLock();

    public NoReadWriteLockCalendarUser(String name) {
        this.name = name;
    }

    public void run() {
        while (today < WEEKDAYS.length-1){
            if (name.contains("Writer")) { // update the shared calendar
                marker.lock();
                try {
                    today = (today+1) % 7;
                    System.out.println(name + " updated date to " + WEEKDAYS[today]);
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    marker.unlock();
                }
            } else { // Reader - check to see what today is
                marker.lock();
                try {
                    System.out.println(name+ " sees that today is " + WEEKDAYS[today]);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    marker.unlock();
                }
            }
        }
    }
}

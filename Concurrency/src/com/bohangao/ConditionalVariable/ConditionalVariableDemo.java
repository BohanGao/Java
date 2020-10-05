package com.bohangao.ConditionalVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionalVariableDemo {
    public static void demo(){
        List<Thread> persons = new ArrayList<>();
        for(int i=0;i<5;i++){
            Thread person = new Thread(new HungryPerson(i));
            persons.add(person);
            person.start();
        }
        for(int i=0;i<5;i++){
            try {
                persons.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class HungryPerson implements Runnable{

    private int personID;
    private static Lock slowCookerLid = new ReentrantLock();
    private static int servings = 11;
    private static Condition soupTaken = slowCookerLid.newCondition();

    public HungryPerson(int personID) {
        this.personID = personID;
    }

    @Override
    public void run() {
        while(servings>0){
            slowCookerLid.lock();
            try {
                while (personID != servings % 5 && servings > 0) {
                    System.out.format("Person %d checked... then put the lid back.\n", personID);
                    soupTaken.await();
                }
                if (servings > 0) {
                    servings--;
                    System.out.format("Person %d took some soup! Servings left: %d\n", personID, servings);
                    soupTaken.signalAll();//signal before unlocking
                }
            } catch (InterruptedException iex){
                iex.printStackTrace();
            } finally {
                slowCookerLid.unlock();
            }
        }
    }
}

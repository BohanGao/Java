package com.bohangao.ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerDemo {
    public static void demo() {
        BlockingQueue<String> soupServingLine = new ArrayBlockingQueue<String>(5);
        Thread thomas = new Thread(new SoupConsumer(soupServingLine));
        Thread taro = new Thread(new SoupProducer(soupServingLine));
        Thread ashley = new Thread(new SoupProducer(soupServingLine));

        thomas.start();
        taro.start();
        ashley.start();

        try {
            thomas.join();
            taro.join();
            ashley.join();
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
    }
}

class SoupProducer implements Runnable {

    private BlockingQueue servingLine;

    public SoupProducer(BlockingQueue servingLine) {
        this.servingLine = servingLine;
    }

    public void run() {
        for (int i = 0; i < 20; i++) { // serve 20 bowls of soup
            try {
                if(servingLine.size()<5){
                    servingLine.add("Bowl #" + i);
                    System.out.format("Served Bowl #%d - remaining capacity: %d\n", i, servingLine.remainingCapacity());
                }
                Thread.sleep(200); // time to serve a bowl of soup
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        servingLine.add("no soup for you!");
        servingLine.add("no soup for you!");
    }
}

class SoupConsumer implements Runnable {

    private BlockingQueue servingLine;

    public SoupConsumer(BlockingQueue servingLine) {
        this.servingLine = servingLine;
    }

    public void run() {
        while (true) {
            try {
                String bowl = (String) servingLine.take();
                if (bowl.equals("no soup for you!")){
                    break;
                }
                System.out.format("Ate %s\n", bowl);
                Thread.sleep(100); // time to eat a bowl of soup
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

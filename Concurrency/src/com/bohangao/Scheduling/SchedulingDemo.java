package com.bohangao.Scheduling;

public class SchedulingDemo {
    public static void demo() throws InterruptedException {
        VegetableChopper ashley = new VegetableChopper("ashley");
        VegetableChopper thomas = new VegetableChopper("thomas");

        ashley.start();
        thomas.start();
        Thread.sleep(1000);
        VegetableChopper.chopping = false;

        ashley.join();
        thomas.join();

        System.out.format("ashley chopped %d vegetables.", ashley.vegetable_count);
        System.out.format("thomas chopped %d vegetables.", thomas.vegetable_count);
    }
}

class VegetableChopper extends Thread{
    public int vegetable_count = 0;
    public static boolean chopping = true;

    public VegetableChopper(String name){
        this.setName(name);
    }

    @Override
    public void run() {
        while(chopping){
            System.out.println(this.getName()+"chopped a vegetable!");
            vegetable_count++;
        }
    }

}
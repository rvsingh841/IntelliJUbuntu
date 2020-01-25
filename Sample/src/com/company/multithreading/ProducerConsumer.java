package com.company.multithreading;


import java.util.LinkedList;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        final PC pc = new PC();
        //create producer thread
        Runnable thread1 = ()->{
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable thread2 = ()->{
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }

    public static class PC{
        LinkedList<Integer> linkedList =  new LinkedList();
        int capacity = 2;
        public void produce() throws InterruptedException {
            int value = 0;
            while (true){
                while (linkedList.size()==capacity){
                    wait();
                }
                System.out.println("Producer produced - " + value);
                linkedList.add(value++);
                notify();
                Thread.sleep(1000);
            }
        }
        public void consume() throws InterruptedException {
            while (true){
                while (linkedList.size()==0){
                    wait();
                }
                int val = linkedList.removeFirst();
                System.out.println("Consumer consumed " + val);
                notify();
                Thread.sleep(1000);
            }
        }

    }
}

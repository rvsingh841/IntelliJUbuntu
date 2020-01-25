package com.company.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Deadlock {
    public static void main(String[] args) {
        final String resource1 = "Ravi";
        final String resource2 = "Palak";
        ExecutorService service=null;
        try{
            service = Executors.newFixedThreadPool(2);
            service.execute(()-> {synchronized (resource1){
                System.out.println(Thread.currentThread().getName() + " locked " + resource1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2){
                    System.out.println(Thread.currentThread().getName() + "requesting " + resource2);
                }
            }});
            service.execute(()->{
                synchronized (resource2){
                    System.out.println(Thread.currentThread().getName() + " locked " + resource2);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resource1){
                        System.out.println(Thread.currentThread().getName() + "requesting " + resource1);
                    }
                }
            });
        }finally {
            service.shutdown();
        }


    }
}

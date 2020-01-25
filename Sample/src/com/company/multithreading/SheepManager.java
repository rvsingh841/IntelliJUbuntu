package com.company.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {
    private AtomicInteger sheepCount = new AtomicInteger(0);
    private void countAndReport(){
        System.out.println(sheepCount.incrementAndGet() + " ");
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try{
            service = Executors.newFixedThreadPool(20);
            SheepManager sheepManager = new SheepManager();
            for (int i=0;i<10;i++){
                service.submit(()->sheepManager.countAndReport());
            }
        }finally {
            if (service!=null){
                service.shutdown();
            }
        }
    }
}

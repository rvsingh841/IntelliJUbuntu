package com.company.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CheckResults  {
    private static int couter = 0;

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();
            Future<?> future = executorService.submit(()->{ for (int i = 0; i <500 ; i++) CheckResults.couter++;

            });
            future.get(10, TimeUnit.SECONDS);
            System.out.println("Reached");
        }finally {
            if (executorService!=null){
                executorService.shutdown();
            }
        }
    }
}

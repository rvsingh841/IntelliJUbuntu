package com.company.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("Begin");
            service.execute(()-> IntStream.range(1,1000000).forEach(el-> System.out.println("printing PrintData" + el)));
            service.execute(()->IntStream.range(1,1000000).forEach(el-> System.out.println("extending thread " + el)));
            service.execute(()->IntStream.range(1,1000000).forEach(el-> System.out.println("extending thread 2" + el)));
            System.out.println("end");

        }finally {
            if (service!=null){
                service.shutdown();
            }
        }
    }
}

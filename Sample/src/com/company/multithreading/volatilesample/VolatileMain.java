package com.company.multithreading.volatilesample;

public class VolatileMain {
    private final static int noOfThreads = 2;

    public static void main(String[] args) throws InterruptedException {
        VolatileData data = new VolatileData();
        Thread[] threads = new Thread[noOfThreads];
        for (int i=0;i<noOfThreads;++i){
            threads[i] = new VolatileThread(data);
        }
        for (int i=0;i<noOfThreads;++i){
            threads[i].start();
            threads[i].join();
        }

    }
}

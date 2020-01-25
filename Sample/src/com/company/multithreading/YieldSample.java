package com.company.multithreading;

class MyThread extends  Thread{
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println("in " + Thread.currentThread().getName());
        }
    }
}
public class YieldSample {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i=0;i<5;i++){
            Thread.yield();
            System.out.println("in " + Thread.currentThread().getName());
        }
    }


}

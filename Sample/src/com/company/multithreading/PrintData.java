package com.company.multithreading;

import java.util.stream.IntStream;

public class PrintData implements Runnable {

    @Override
    public void run() {
        //IntStream.of(1,2,3,4,5,6,7,8,9,10).forEach(el-> System.out.println(el));
        int sum = 0;
        for (int i=0;i<5;i++){
            sum+=i;
            System.out.println("Printing...." + i);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        System.out.println("Begin");
        new Thread(new PrintData()).start();
        new ReadInventory().start();
        new Thread(new PrintData()).start();
        System.out.println("end");
    }
}

class ReadInventory extends Thread{
    @Override
    public void run() {
        IntStream.range(1,5).forEach(el-> System.out.println("extending thread " + el));
        System.out.println("from thread " + IntStream.range(1,5).sum());

    }


}

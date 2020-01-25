package com.company.multithreading;

class Customer{
    int amount = 10000;
    public synchronized void withdraw(int amount) throws InterruptedException {
        System.out.println("Going to withdraw.....");
        if (this.amount<amount){
            System.out.println("Less balance.Waiting for deposit....");
            wait();
        }
        System.out.println("Withdraw is completed");
    }

    public synchronized void deposit(int amount){
        System.out.println("Going to depositt....");
        this.amount += amount;
        System.out.println("deposit completed....");
        notify();

    }
}
public class InterThread {


    public static void main(String[] args) {
        Customer customer = new Customer();
        Runnable thread1 = ()->{
            try {
                customer.withdraw(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable thread2 = ()->{
            customer.deposit(6000);
        };
        Thread t1= new Thread(thread1);
        Thread t2 = new Thread(thread2);
        t1.start();
        t2.start();
    }

}

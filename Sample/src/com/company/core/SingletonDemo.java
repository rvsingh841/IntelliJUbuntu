package com.company.core;

public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println(Singleton.getObject(10));
        System.out.println(Singleton.getObject(20));
    }
}

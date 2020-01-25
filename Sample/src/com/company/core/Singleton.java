package com.company.core;

public class Singleton {
    private static Singleton singleton;
    private int a;
    private Singleton(){}

    private Singleton(int a) {
        this.a = a;
    }

    public static Singleton getObject(int a){
        if (singleton==null){
            singleton = new Singleton(a);
        }
        return singleton;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "a=" + a +
                '}';
    }
}
